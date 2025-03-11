package com.tcc.demo.Controller;


import com.tcc.demo.Service.LudopediaDetalheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalhes")
@Tag(name = "Detalhamento de Jogos",
        description = "Controller para detalhar jogos que ainda não foram processados")
public class JogoDetalhadoController {

    private final LudopediaDetalheService detalheService;

    public JogoDetalhadoController(LudopediaDetalheService detalheService) {
        this.detalheService = detalheService;
    }

    /**
     * Endpoint para processar todos os jogos que estão marcados como não-detalhados
     * na tabela 'jogo_resumido', buscá-los na API e inserir nas tabelas de detalhe.
     *
     * @param accessToken Token de acesso OAuth2 (Bearer token) para a Ludopedia
     * @return Mensagem de sucesso ou falha
     */
    @Operation(summary = "Processar jogos não detalhados",
            description = "Busca dados detalhados na Ludopedia e salva em jogo_detalhado e tabelas relacionadas")
    @PostMapping("/processar")
    public ResponseEntity<String> processarDetalhesNaoProcessados(
            @RequestParam String accessToken
    ) {
        try {
            detalheService.processarDetalhesNaoProcessados(accessToken);
            return ResponseEntity.ok("Detalhes processados com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Falha ao processar detalhes: " + e.getMessage());
        }
    }
}
