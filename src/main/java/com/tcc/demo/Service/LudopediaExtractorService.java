package com.tcc.demo.Service;


import com.tcc.demo.DTO.JogoResumoTO;
import com.tcc.demo.DTO.JogosResponseTO;
import com.tcc.demo.Model.JogoResumido;
import com.tcc.demo.Repository.JogoResumidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;



import java.util.ArrayList;
import java.util.List;

@Service
public class LudopediaExtractorService {

    String accessToken = "fb8b74b6baf83cfa05dd4cc46bda9b27";
    private static final String BASE_URL = "https://ludopedia.com.br/api/v1/jogos";
    private final JogoResumidoRepository jogoRepo;

    public LudopediaExtractorService(JogoResumidoRepository jogoRepo) {
        this.jogoRepo = jogoRepo;
    }

    public List<JogoResumido> extrairJogos(int rows) {
        RestTemplate restTemplate = new RestTemplate();

        int quantidadeNoBanco = (int) jogoRepo.count();

        int page = quantidadeNoBanco/rows;
        List<JogoResumido> todosJogosSalvos = new ArrayList<>();

        while (true) {

            String url = String.format("%s?page=%d&rows=%d", BASE_URL, page, rows);

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken); // Authorization: Bearer <token>
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<JogosResponseTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    JogosResponseTO.class
            );

            JogosResponseTO resposta = response.getBody();
            if (resposta.getJogos() == null || resposta.getJogos().isEmpty()) {
                break;
            }

            for (JogoResumoTO dto : resposta.getJogos()) {
                // Verifica se já existe no banco (opcional)
                JogoResumido existente = jogoRepo.findByIdExterno(dto.getId_jogo());

                if (existente == null) {
                    // Cria novo registro
                    existente = new JogoResumido();
                    existente.setIdExterno(dto.getId_jogo());
                }

                existente.setNomeJogo(dto.getNm_jogo());
                // se tiver mais campos, atualize aqui
                jogoRepo.save(existente);

                todosJogosSalvos.add(existente);
            }

            // Verifica total (opcional, se a API retornar)
            int total = resposta.getTotal();
            if (page * rows >= total) {
                break;
            }

            page++;
        }

        return todosJogosSalvos;
    }

    public List<JogoResumido> listarTodosJogos() {
        return jogoRepo.findAll();
    }

}

