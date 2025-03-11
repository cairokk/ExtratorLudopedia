package com.tcc.demo.Controller;

import com.tcc.demo.Model.JogoResumido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.tcc.demo.Service.LudopediaExtractorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@Tag(name = "Jogos", description = "Controller para extrair e gerenciar jogos da Ludopedia")
public class JogoResumidoController {

    private final LudopediaExtractorService extractorService;

    public JogoResumidoController(LudopediaExtractorService extractorService) {
        this.extractorService = extractorService;
    }

    @Operation(summary = "Extrair e salvar jogos da Ludopedia",
            description = "Faz chamadas paginadas à API e salva os jogos no banco de dados local")
    @PostMapping("/extrair")
    public ResponseEntity<List<JogoResumido>> extrairJogos(
            @RequestParam(defaultValue = "20") int rows
    ) {
        // Aqui você dispara o processo de extrair jogos (paginado)
        // e retorna a lista salva
        List<JogoResumido> jogosSalvos = extractorService.extrairJogos(rows);
        return ResponseEntity.ok(jogosSalvos);
    }

    @Operation(summary = "Listar jogos salvos",
            description = "Retorna todos os registros de jogos armazenados localmente no banco.")
    @GetMapping
    public ResponseEntity<List<JogoResumido>> listarJogos() {
        List<JogoResumido> lista = extractorService.listarTodosJogos();
        return ResponseEntity.ok(lista);
    }
}
