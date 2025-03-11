package com.tcc.demo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogo_detalhado")
public class JogoDetalhado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;             // chave primária local
    @OneToOne
    @JoinColumn(name = "id_externo", referencedColumnName = "id_externo", unique = true)
    private JogoResumido jogoResumido;
    private String nmJogo;       // "nm_jogo"
    private String thumb;
    private String tpJogo;
    private String link;
    private Integer anoPublicacao;
    private Integer anoNacional;
    private Integer qtJogadoresMin;
    private Integer qtJogadoresMax;
    private Integer vlTempoJogo;
    private Integer idadeMinima;
    private Integer qtTem;       // "qt_tem"
    private Integer qtTeve;      // "qt_teve"
    private Integer qtFavorito;  // "qt_favorito"
    private Integer qtQuer;      // "qt_quer"
    private Integer qtJogou;     // "qt_jogou"

    // Relações com tabelas auxiliares
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "jogo_mecanica",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "mecanica_id")
    )
    private List<Mecanica> mecanicas = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "jogo_tema",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id")
    )
    private List<Tema> temas = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "jogo_categoria",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "jogo_artista",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artista> artistas = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "jogo_designer",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "designer_id")
    )
    private List<Designer> designers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JogoResumido getJogoResumido() {
        return jogoResumido;
    }

    public void setJogoResumido(JogoResumido jogoResumido) {
        this.jogoResumido = jogoResumido;
    }

    public String getNmJogo() {
        return nmJogo;
    }

    public void setNmJogo(String nmJogo) {
        this.nmJogo = nmJogo;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTpJogo() {
        return tpJogo;
    }

    public void setTpJogo(String tpJogo) {
        this.tpJogo = tpJogo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getAnoNacional() {
        return anoNacional;
    }

    public void setAnoNacional(Integer anoNacional) {
        this.anoNacional = anoNacional;
    }

    public Integer getQtJogadoresMin() {
        return qtJogadoresMin;
    }

    public void setQtJogadoresMin(Integer qtJogadoresMin) {
        this.qtJogadoresMin = qtJogadoresMin;
    }

    public Integer getQtJogadoresMax() {
        return qtJogadoresMax;
    }

    public void setQtJogadoresMax(Integer qtJogadoresMax) {
        this.qtJogadoresMax = qtJogadoresMax;
    }

    public Integer getVlTempoJogo() {
        return vlTempoJogo;
    }

    public void setVlTempoJogo(Integer vlTempoJogo) {
        this.vlTempoJogo = vlTempoJogo;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(Integer idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public Integer getQtTem() {
        return qtTem;
    }

    public void setQtTem(Integer qtTem) {
        this.qtTem = qtTem;
    }

    public Integer getQtTeve() {
        return qtTeve;
    }

    public void setQtTeve(Integer qtTeve) {
        this.qtTeve = qtTeve;
    }

    public Integer getQtFavorito() {
        return qtFavorito;
    }

    public void setQtFavorito(Integer qtFavorito) {
        this.qtFavorito = qtFavorito;
    }

    public Integer getQtQuer() {
        return qtQuer;
    }

    public void setQtQuer(Integer qtQuer) {
        this.qtQuer = qtQuer;
    }

    public Integer getQtJogou() {
        return qtJogou;
    }

    public void setQtJogou(Integer qtJogou) {
        this.qtJogou = qtJogou;
    }

    public List<Mecanica> getMecanicas() {
        return mecanicas;
    }

    public void setMecanicas(List<Mecanica> mecanicas) {
        this.mecanicas = mecanicas;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<Designer> getDesigners() {
        return designers;
    }

    public void setDesigners(List<Designer> designers) {
        this.designers = designers;
    }
}
