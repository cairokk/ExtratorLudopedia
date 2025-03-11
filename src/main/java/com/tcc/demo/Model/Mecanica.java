package com.tcc.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "mecanica")
public class Mecanica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // chave primária local
    private Long idExterno;   // id_mecanica da API
    private String nmMecanica;

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

    public String getNmMecanica() {
        return nmMecanica;
    }

    public void setNmMecanica(String nmMecanica) {
        this.nmMecanica = nmMecanica;
    }
}

