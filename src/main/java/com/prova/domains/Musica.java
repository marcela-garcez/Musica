package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prova.domains.enums.Popularidade;
import com.prova.dtos.MusicaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name="musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_musica")
    private Long idMusica;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String genero;

    @NotNull
    @NotBlank
    private String duracao;

    @NotNull
    @NotBlank
    private String anoLancamento;

    @ManyToOne
    @JoinColumn(name = "idcantor")
    private Cantor cantor;

    @ManyToOne
    @JoinColumn(name = "idalbum")
    @JsonBackReference
    private Album album;

    @ManyToOne
    @JoinColumn(name = "idgravadora")
    private Gravadora gravadora;

    @Enumerated(EnumType.STRING)
    @Column(name = "popularidade")
    private Popularidade popularidade;

    public Musica(MusicaDTO dto) {
        this.idMusica = dto.getIdMusica();
        this.nome = dto.getNome();
        this.genero = dto.getGenero();
        this.duracao = dto.getDuracao();
        this.anoLancamento = dto.getAnoLancamento();
        this.cantor = new Cantor();
        this.cantor.setId(dto.getCantor());
        this.album = new Album();
        this.album.setId(dto.getAlbum());
        this.gravadora = new Gravadora();
        this.gravadora.setId(dto.getGravadora());
        this.popularidade = Popularidade.toEnum(dto.getPopularidade());

    }
    public Musica() {
    }

    public Musica(Long idMusica, String nome, String genero, String duracao, String anoLancamento, Cantor cantor, Album album, Gravadora gravadora, Popularidade popularidade) {
        this.idMusica = idMusica;
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.cantor = cantor;
        this.album = album;
        this.gravadora = gravadora;
        this.popularidade = popularidade;
    }

    public Long getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Long idMusica) {
        this.idMusica = idMusica;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getGenero() {
        return genero;
    }

    public void setGenero(@NotNull @NotBlank String genero) {
        this.genero = genero;
    }

    public @NotNull @NotBlank String getDuracao() {
        return duracao;
    }

    public void setDuracao(@NotNull @NotBlank String duracao) {
        this.duracao = duracao;
    }

    public @NotNull @NotBlank String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(@NotNull @NotBlank String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    public Popularidade getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Popularidade popularidade) {
        this.popularidade = popularidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return Objects.equals(idMusica, musica.idMusica) && Objects.equals(nome, musica.nome) && Objects.equals(genero, musica.genero) && Objects.equals(duracao, musica.duracao) && Objects.equals(anoLancamento, musica.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMusica, nome, genero, duracao, anoLancamento);
    }
}