package com.prova.dtos;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.domains.Gravadora;
import com.prova.domains.Musica;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MusicaDTO {

    private Long idMusica;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo genero não pode ser nulo!")
    @NotBlank(message = "O campo genero não pode ser vazio!")
    private String genero;

    @NotNull(message = "O campo duração não pode ser nulo!")
    @NotBlank(message = "O campo duração não pode ser vazio!")
    private String duracao;

    @NotNull(message = "O campo ano de lançamento não pode ser nulo!")
    @NotBlank(message = "O campo ano de lançamento não pode ser vazio!")
    private String anoLancamento;


    @NotNull(message = "O campo album não pode ser nulo!")
    private Integer album;
    private String nomeAlbum;

    @NotNull(message = "O campo cantor não pode ser nulo!")
    private Integer cantor;
    private String nomeCantor;
    private String nomeArtisticoCantor;
    private String estiloMusicalCantor;
    private String CPF;

    @NotNull(message = "O campo gravadora não pode ser nulo!")
    private Integer gravadora;
    private String nomeGravadora;
    private String CNPJGravadora;
    private String sedeGravadora;

    private int popularidade;

    public MusicaDTO() {
    }

    public MusicaDTO(Musica musica) {
        this.idMusica = musica.getIdMusica();
        this.nome = musica.getNome();
        this.genero = musica.getGenero();
        this.duracao = musica.getDuracao();
        this.anoLancamento = musica.getAnoLancamento();
        this.album = musica.getAlbum().getId();
        this.nomeAlbum = musica.getAlbum().getNome();
        this.cantor = musica.getCantor().getId();
        this.nomeCantor = musica.getCantor().getNome();
        this.nomeArtisticoCantor = musica.getCantor().getNomeArtistico();
        this.estiloMusicalCantor = musica.getCantor().getEstiloMusical();
        this.CPF = musica.getCantor().getCPF();
        this.gravadora = musica.getGravadora().getId();
        this.nomeGravadora = musica.getGravadora().getNome();
        this.CNPJGravadora = musica.getGravadora().getCNPJ();
        this.sedeGravadora = musica.getGravadora().getSede();
        this.popularidade = musica.getPopularidade().getId();
    }


    public Long getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Long idMusica) {
        this.idMusica = idMusica;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo genero não pode ser nulo!") @NotBlank(message = "O campo genero não pode ser vazio!") String getGenero() {
        return genero;
    }

    public void setGenero(@NotNull(message = "O campo genero não pode ser nulo!") @NotBlank(message = "O campo genero não pode ser vazio!") String genero) {
        this.genero = genero;
    }

    public @NotNull(message = "O campo duração não pode ser nulo!") @NotBlank(message = "O campo duração não pode ser vazio!") String getDuracao() {
        return duracao;
    }

    public void setDuracao(@NotNull(message = "O campo duração não pode ser nulo!") @NotBlank(message = "O campo duração não pode ser vazio!") String duracao) {
        this.duracao = duracao;
    }

    public @NotNull(message = "O campo ano de lançamento não pode ser nulo!") @NotBlank(message = "O campo ano de lançamento não pode ser vazio!") String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(@NotNull(message = "O campo ano de lançamento não pode ser nulo!") @NotBlank(message = "O campo ano de lançamento não pode ser vazio!") String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public @NotNull(message = "O campo album não pode ser nulo!") Integer getAlbum() {
        return album;
    }

    public void setAlbum(@NotNull(message = "O campo album não pode ser nulo!") Integer album) {
        this.album = album;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public @NotNull(message = "O campo cantor não pode ser nulo!") Integer getCantor() {
        return cantor;
    }

    public void setCantor(@NotNull(message = "O campo cantor não pode ser nulo!") Integer cantor) {
        this.cantor = cantor;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public String getNomeArtisticoCantor() {
        return nomeArtisticoCantor;
    }

    public void setNomeArtisticoCantor(String nomeArtisticoCantor) {
        this.nomeArtisticoCantor = nomeArtisticoCantor;
    }

    public String getEstiloMusicalCantor() {
        return estiloMusicalCantor;
    }

    public void setEstiloMusicalCantor(String estiloMusicalCantor) {
        this.estiloMusicalCantor = estiloMusicalCantor;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public @NotNull(message = "O campo gravadora não pode ser nulo!") Integer getGravadora() {
        return gravadora;
    }

    public void setGravadora(@NotNull(message = "O campo gravadora não pode ser nulo!") Integer gravadora) {
        this.gravadora = gravadora;
    }

    public String getNomeGravadora() {
        return nomeGravadora;
    }

    public void setNomeGravadora(String nomeGravadora) {
        this.nomeGravadora = nomeGravadora;
    }

    public String getCNPJGravadora() {
        return CNPJGravadora;
    }

    public void setCNPJGravadora(String CNPJGravadora) {
        this.CNPJGravadora = CNPJGravadora;
    }

    public String getSedeGravadora() {
        return sedeGravadora;
    }

    public void setSedeGravadora(String sedeGravadora) {
        this.sedeGravadora = sedeGravadora;
    }

    public int getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(int popularidade) {
        this.popularidade = popularidade;
    }
}
