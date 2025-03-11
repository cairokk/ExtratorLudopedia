package com.tcc.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JogoResumoTO {
    private Long id_jogo;
    private String nm_jogo;

    public Long getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(Long id_jogo) {
        this.id_jogo = id_jogo;
    }

    public String getNm_jogo() {
        return nm_jogo;
    }

    public void setNm_jogo(String nm_jogo) {
        this.nm_jogo = nm_jogo;
    }

    // Caso precise de mais campos, inclua aqui
}
