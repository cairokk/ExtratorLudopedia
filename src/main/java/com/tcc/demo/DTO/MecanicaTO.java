package com.tcc.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MecanicaTO {
    private Long id_mecanica;
    private String nm_mecanica;

    public Long getId_mecanica() {
        return id_mecanica;
    }

    public void setId_mecanica(Long id_mecanica) {
        this.id_mecanica = id_mecanica;
    }

    public String getNm_mecanica() {
        return nm_mecanica;
    }

    public void setNm_mecanica(String nm_mecanica) {
        this.nm_mecanica = nm_mecanica;
    }
}
