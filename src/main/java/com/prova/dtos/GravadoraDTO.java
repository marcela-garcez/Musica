package com.prova.dtos;

import com.prova.domains.Gravadora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GravadoraDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo CNPJ não pode ser nulo!")
    @NotBlank(message = "O campo CNPJ não pode ser vazio!")
    private String CNPJ;

    @NotNull(message = "O campo sede não pode ser nulo!")
    @NotBlank(message = "O campo sede não pode ser vazio!")
    private String sede;

    public GravadoraDTO() {
    }

    public GravadoraDTO(Gravadora gravadora) {
        this.id = gravadora.getId();
        this.nome = gravadora.getNome();
        this.CNPJ = gravadora.getCNPJ();
        this.sede = gravadora.getSede();
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

    public @NotNull(message = "O campo CNPJ não pode ser nulo!") @NotBlank(message = "O campo CNPJ não pode ser vazio!") String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(@NotNull(message = "O campo CNPJ não pode ser nulo!") @NotBlank(message = "O campo CNPJ não pode ser vazio!") String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public @NotNull(message = "O campo sede não pode ser nulo!") @NotBlank(message = "O campo sede não pode ser vazio!") String getSede() {
        return sede;
    }

    public void setSede(@NotNull(message = "O campo sede não pode ser nulo!") @NotBlank(message = "O campo sede não pode ser vazio!") String sede) {
        this.sede = sede;
    }
}
