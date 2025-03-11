package com.tcc.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JogoDetalhadoTO {

    private Long id_jogo;
    private String nm_jogo;
    private String thumb;
    private String tp_jogo;
    private String link;
    private Integer ano_publicacao;
    private Integer ano_nacional;
    private Integer qt_jogadores_min;
    private Integer qt_jogadores_max;
    private Integer vl_tempo_jogo;
    private Integer idade_minima;
    private Integer qt_tem;
    private Integer qt_teve;
    private Integer qt_favorito;
    private Integer qt_quer;
    private Integer qt_jogou;

    private List<MecanicaTO> mecanicas;
    private List<CategoriaTO> categorias;
    private List<TemaTO> temas;
    private List<ProfissionalTO> artistas;
    private List<ProfissionalTO> designers;

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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTp_jogo() {
        return tp_jogo;
    }

    public void setTp_jogo(String tp_jogo) {
        this.tp_jogo = tp_jogo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public Integer getAno_nacional() {
        return ano_nacional;
    }

    public void setAno_nacional(Integer ano_nacional) {
        this.ano_nacional = ano_nacional;
    }

    public Integer getQt_jogadores_min() {
        return qt_jogadores_min;
    }

    public void setQt_jogadores_min(Integer qt_jogadores_min) {
        this.qt_jogadores_min = qt_jogadores_min;
    }

    public Integer getQt_jogadores_max() {
        return qt_jogadores_max;
    }

    public void setQt_jogadores_max(Integer qt_jogadores_max) {
        this.qt_jogadores_max = qt_jogadores_max;
    }

    public Integer getVl_tempo_jogo() {
        return vl_tempo_jogo;
    }

    public void setVl_tempo_jogo(Integer vl_tempo_jogo) {
        this.vl_tempo_jogo = vl_tempo_jogo;
    }

    public Integer getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(Integer idade_minima) {
        this.idade_minima = idade_minima;
    }

    public Integer getQt_tem() {
        return qt_tem;
    }

    public void setQt_tem(Integer qt_tem) {
        this.qt_tem = qt_tem;
    }

    public Integer getQt_teve() {
        return qt_teve;
    }

    public void setQt_teve(Integer qt_teve) {
        this.qt_teve = qt_teve;
    }

    public Integer getQt_favorito() {
        return qt_favorito;
    }

    public void setQt_favorito(Integer qt_favorito) {
        this.qt_favorito = qt_favorito;
    }

    public Integer getQt_quer() {
        return qt_quer;
    }

    public void setQt_quer(Integer qt_quer) {
        this.qt_quer = qt_quer;
    }

    public Integer getQt_jogou() {
        return qt_jogou;
    }

    public void setQt_jogou(Integer qt_jogou) {
        this.qt_jogou = qt_jogou;
    }

    public List<MecanicaTO> getMecanicas() {
        return mecanicas;
    }

    public void setMecanicas(List<MecanicaTO> mecanicas) {
        this.mecanicas = mecanicas;
    }

    public List<CategoriaTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaTO> categorias) {
        this.categorias = categorias;
    }

    public List<TemaTO> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaTO> temas) {
        this.temas = temas;
    }

    public List<ProfissionalTO> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<ProfissionalTO> artistas) {
        this.artistas = artistas;
    }

    public List<ProfissionalTO> getDesigners() {
        return designers;
    }

    public void setDesigners(List<ProfissionalTO> designers) {
        this.designers = designers;
    }
}

