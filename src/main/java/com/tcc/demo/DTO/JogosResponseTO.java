package com.tcc.demo.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JogosResponseTO {

    private List<JogoResumoTO> jogos;
    private int total;
    public List<JogoResumoTO> getJogos() {
        return jogos;
    }

    public void setJogos(List<JogoResumoTO> jogos) {
        this.jogos = jogos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



}
