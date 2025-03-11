package com.tcc.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfissionalTO {
    private Long id_profissional;
    private String nm_profissional;

    public Long getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(Long id_profissional) {
        this.id_profissional = id_profissional;
    }

    public String getNm_profissional() {
        return nm_profissional;
    }

    public void setNm_profissional(String nm_profissional) {
        this.nm_profissional = nm_profissional;
    }
}
