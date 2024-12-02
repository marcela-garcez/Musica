package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.dtos.CantorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cantor")
public class Cantor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cantor")
    private Integer id;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String nomeArtistico;

    @NotNull @NotBlank
    private String estiloMusical;

    @NotNull @NotBlank
    private String CPF;

    @JsonIgnore
    @OneToMany(mappedBy = "cantor")
    private List<Musica> musica = new ArrayList<>();

    public List<Musica> getMusicas(){
        return musica;
    }


    public Cantor(CantorDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.nomeArtistico = dto.getNomeArtistico();
        this.estiloMusical = dto.getEstiloMusical();
        this.CPF = dto.getCPF();
    }

    public Cantor(Integer id, String nome, String nomeArtistico, String estiloMusical, String CPF) {
        this.id = id;
        this.nome = nome;
        this.nomeArtistico = nomeArtistico;
        this.estiloMusical = estiloMusical;
        this.CPF = CPF;
    }

    public Cantor() {

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

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantor cantor = (Cantor) o;
        return Objects.equals(id, cantor.id) && Objects.equals(nome, cantor.nome) && Objects.equals(nomeArtistico, cantor.nomeArtistico) && Objects.equals(estiloMusical, cantor.estiloMusical) && Objects.equals(CPF, cantor.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nomeArtistico, estiloMusical, CPF);
    }
}
