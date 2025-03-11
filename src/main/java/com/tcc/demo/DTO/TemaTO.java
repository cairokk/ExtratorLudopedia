package com.tcc.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemaTO {
    private Long id_tema;
    private String nm_tema;

    public Long getId_tema() {
        return id_tema;
    }

    public void setId_tema(Long id_tema) {
        this.id_tema = id_tema;
    }

    public String getNm_tema() {
        return nm_tema;
    }

    public void setNm_tema(String nm_tema) {
        this.nm_tema = nm_tema;
    }
}
