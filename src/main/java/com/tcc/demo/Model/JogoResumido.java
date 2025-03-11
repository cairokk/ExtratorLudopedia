package com.tcc.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "jogo_resumido")
public class JogoResumido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID interno do seu banco

    @Column(name = "id_externo", nullable = false, unique = true)
    private Long idExterno; // ID do jogo na API Ludopedia

    @Column(name = "nome_jogo", nullable = false)
    private String nomeJogo;

    private boolean detalhado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(Long idExterno) {
        this.idExterno = idExterno;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public boolean isDetalhado() {
        return detalhado;
    }

    public void setDetalhado(boolean detalhado) {
        this.detalhado = detalhado;
    }
}
