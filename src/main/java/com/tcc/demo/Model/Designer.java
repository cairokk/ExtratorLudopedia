package com.tcc.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "designer")
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idExterno; // id_tema da API
    private String nmProfissional;

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

    public String getNmProfissional() {
        return nmProfissional;
    }

    public void setNmProfissional(String nmProfissional) {
        this.nmProfissional = nmProfissional;
    }
}

