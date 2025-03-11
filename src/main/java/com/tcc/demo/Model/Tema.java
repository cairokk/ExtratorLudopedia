package com.tcc.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idExterno; // id_tema da API
    private String nmTema;

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

    public String getNmTema() {
        return nmTema;
    }

    public void setNmTema(String nmTema) {
        this.nmTema = nmTema;
    }
}
