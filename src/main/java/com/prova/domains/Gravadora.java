package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.dtos.GravadoraDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="gravadora")
public class Gravadora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gravadora")
    private Integer id;

    @NotBlank @NotNull
    private String nome;

    @NotBlank @NotNull
    private String CNPJ;

    @NotBlank @NotNull
    private String sede;

    @JsonIgnore
    @OneToMany(mappedBy = "gravadora")
    private List<Musica> musica = new ArrayList<>();

    public List<Musica> getMusicas(){
        return musica;
    }

    public Gravadora(GravadoraDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.CNPJ = dto.getCNPJ();
        this.sede = dto.getSede();
    }

    public Gravadora(Integer id, String nome, String CNPJ, String sede) {
        this.id = id;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.sede = sede;
    }

    public Gravadora() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gravadora gravadora = (Gravadora) o;
        return Objects.equals(id, gravadora.id) && Objects.equals(nome, gravadora.nome) && Objects.equals(CNPJ, gravadora.CNPJ) && Objects.equals(sede, gravadora.sede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, CNPJ, sede);
    }
}
