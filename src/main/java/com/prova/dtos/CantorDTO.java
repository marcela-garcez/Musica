package com.prova.dtos;

import com.prova.domains.Cantor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CantorDTO {
    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo nome artistico não pode ser nulo!")
    @NotBlank(message = "O campo nome artisitico não pode ser vazio!")
    private String nomeArtistico;

    @NotNull(message = "O campo estilo musical não pode ser nulo!")
    @NotBlank(message = "O campo estilo musical não pode ser vazio!")
    private String estiloMusical;

    @NotNull(message = "O campo CPF não pode ser nulo!")
    @NotBlank(message = "O campo CPF não pode ser vazio!")
    private String CPF;

    public CantorDTO() {
    }

    public CantorDTO(Cantor cantor) {
        this.id = cantor.getId();
        this.nome = cantor.getNome();
        this.nomeArtistico = cantor.getNomeArtistico();
        this.estiloMusical = cantor.getEstiloMusical();
        this.CPF = cantor.getCPF();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo nome artistico não pode ser nulo!") @NotBlank(message = "O campo nome artisitico não pode ser vazio!") String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(@NotNull(message = "O campo nome artistico não pode ser nulo!") @NotBlank(message = "O campo nome artisitico não pode ser vazio!") String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public @NotNull(message = "O campo estilo musical não pode ser nulo!") @NotBlank(message = "O campo estilo musical não pode ser vazio!") String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(@NotNull(message = "O campo estilo musical não pode ser nulo!") @NotBlank(message = "O campo estilo musical não pode ser vazio!") String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public @NotNull(message = "O campo CPF não pode ser nulo!") @NotBlank(message = "O campo CPF não pode ser vazio!") String getCPF() {
        return CPF;
    }

    public void setCPF(@NotNull(message = "O campo CPF não pode ser nulo!") @NotBlank(message = "O campo CPF não pode ser vazio!") String CPF) {
        this.CPF = CPF;
    }
}
