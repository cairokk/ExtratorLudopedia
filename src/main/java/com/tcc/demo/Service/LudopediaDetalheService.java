package com.tcc.demo.Service;

import com.tcc.demo.DTO.JogoDetalhadoTO;
import com.tcc.demo.Model.*;
import com.tcc.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LudopediaDetalheService {

    private static final String BASE_URL = "https://ludopedia.com.br/api/v1/jogos";

    @Autowired
    private JogoResumidoRepository resumoRepo;
    @Autowired
    private JogoDetalhadoRepository detalhadoRepo;
    @Autowired
    private MecanicaRepository mecanicaRepo;
    @Autowired
    private TemaRepository temaRepo;
    @Autowired
    private CategoriaRepository categoriaRepo;
    @Autowired
    private ArtistaRepository artistaRepo;
    @Autowired
    private DesignerRepository designerRepo;

    @PersistenceContext
    private EntityManager em;

    /**
     * Este método não tem @Transactional. Ele apenas controla a paginação
     * e chama processarPagina(...), onde cada página terá sua própria transação.
     */
    public void processarDetalhesNaoProcessados(String accessToken) {
        int size = 100;

        while (true) {
            // Busca até 100 jogos não detalhados, nessa "página"
            Pageable pageable = PageRequest.of(0, size);
            Page<JogoResumido> pagina = resumoRepo.findByDetalhadoFalse(pageable);

            if (!pagina.hasContent()) {
                // Não há mais jogos pendentes, então encerra
                break;
            }

            // Processa todos os jogos desta página em uma nova transação
            processarPagina(pagina.getContent(), accessToken);

        }
        System.out.println("== Processo concluído ==");
    }

    /**
     * Este método é @Transactional(propagation = REQUIRES_NEW),
     * garantindo que cada página de jogos seja processada numa transação separada.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processarPagina(List<JogoResumido> jogos, String accessToken) {
        for (JogoResumido jr : jogos) {
            try {
                JogoDetalhadoTO dto = buscarDetalhes(jr.getIdExterno(), accessToken);

                // Converte e salva o detalhe
                JogoDetalhado det = converterParaEntidade(dto);
                detalhadoRepo.save(det);

                // Marca o jogo_resumido como detalhado
                jr.setDetalhado(true);
                resumoRepo.save(jr);

                System.out.println("Detalhado: " + jr.getIdExterno());
            } catch (Exception e) {
                System.err.println("Erro ao detalhar jogo ID " + jr.getIdExterno() + ": " + e.getMessage());
            }
        }

        // Se quiser forçar flush/clear no final do lote, pode fazer:
        // em.flush();
        // em.clear();
        // Assim, a transação finaliza ao sair do método,
        // comitando ou fazendo rollback se houver exceção não tratada.
    }

    private JogoDetalhadoTO buscarDetalhes(Long idExterno, String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/" + idExterno;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken); // "Authorization: Bearer <seu_token>"

        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<JogoDetalhadoTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                JogoDetalhadoTO.class
        );

        return response.getBody();
    }

    private JogoDetalhado converterParaEntidade(JogoDetalhadoTO dto) {
        Long idExterno = dto.getId_jogo();
        // Localiza o jogo_resumido correspondente
        JogoResumido jr = resumoRepo.findByIdExterno(idExterno);
        if (jr == null) {
            throw new RuntimeException("Não existe JogoResumido com idExterno=" + idExterno);
        }

        // Verifica se já existe um jogo_detalhado
        JogoDetalhado jd = detalhadoRepo.findByJogoResumido(jr);
        if (jd == null) {
            jd = new JogoDetalhado();
            jd.setJogoResumido(jr);
        }

        // Preenche campos
        jd.setNmJogo(dto.getNm_jogo());
        jd.setThumb(dto.getThumb());
        jd.setTpJogo(dto.getTp_jogo());
        jd.setLink(dto.getLink());
        jd.setAnoPublicacao(dto.getAno_publicacao());
        jd.setAnoNacional(dto.getAno_nacional());
        jd.setQtJogadoresMin(dto.getQt_jogadores_min());
        jd.setQtJogadoresMax(dto.getQt_jogadores_max());
        jd.setVlTempoJogo(dto.getVl_tempo_jogo());
        jd.setIdadeMinima(dto.getIdade_minima());
        jd.setQtTem(dto.getQt_tem());
        jd.setQtTeve(dto.getQt_teve());
        jd.setQtFavorito(dto.getQt_favorito());
        jd.setQtQuer(dto.getQt_quer());
        jd.setQtJogou(dto.getQt_jogou());

        // Mecanicas
        if (dto.getMecanicas() != null) {
            List<Mecanica> mecanicas = dto.getMecanicas().stream().map(mDto -> {
                Mecanica existente = mecanicaRepo.findByIdExterno(mDto.getId_mecanica());
                if (existente == null) {
                    existente = new Mecanica();
                    existente.setIdExterno(mDto.getId_mecanica());
                }
                existente.setNmMecanica(mDto.getNm_mecanica());
                return mecanicaRepo.save(existente);
            }).collect(Collectors.toList());
            jd.setMecanicas(mecanicas);
        }

        // Temas
        if (dto.getTemas() != null) {
            List<Tema> temas = dto.getTemas().stream().map(tDto -> {
                Tema existente = temaRepo.findByIdExterno(tDto.getId_tema());
                if (existente == null) {
                    existente = new Tema();
                    existente.setIdExterno(tDto.getId_tema());
                }
                existente.setNmTema(tDto.getNm_tema());
                return temaRepo.save(existente);
            }).collect(Collectors.toList());
            jd.setTemas(temas);
        }

        // Categorias
        if (dto.getCategorias() != null) {
            List<Categoria> categorias = dto.getCategorias().stream().map(cDto -> {
                Categoria existente = categoriaRepo.findByIdExterno(cDto.getId_categoria());
                if (existente == null) {
                    existente = new Categoria();
                    existente.setIdExterno(cDto.getId_categoria());
                }
                existente.setNmCategoria(cDto.getNm_categoria());
                return categoriaRepo.save(existente);
            }).collect(Collectors.toList());
            jd.setCategorias(categorias);
        }

        // Artistas
        if (dto.getArtistas() != null) {
            List<Artista> artistas = dto.getArtistas().stream().map(aDto -> {
                Artista existente = artistaRepo.findByIdExterno(aDto.getId_profissional());
                if (existente == null) {
                    existente = new Artista();
                    existente.setIdExterno(aDto.getId_profissional());
                }
                existente.setNmProfissional(aDto.getNm_profissional());
                return artistaRepo.save(existente);
            }).collect(Collectors.toList());
            jd.setArtistas(artistas);
        }

        // Designers
        if (dto.getDesigners() != null) {
            List<Designer> designers = dto.getDesigners().stream().map(dDto -> {
                Designer existente = designerRepo.findByIdExterno(dDto.getId_profissional());
                if (existente == null) {
                    existente = new Designer();
                    existente.setIdExterno(dDto.getId_profissional());
                }
                existente.setNmProfissional(dDto.getNm_profissional());
                return designerRepo.save(existente);
            }).collect(Collectors.toList());
            jd.setDesigners(designers);
        }

        return jd;
    }
}
