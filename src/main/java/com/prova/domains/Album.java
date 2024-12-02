package com.prova.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prova.dtos.AlbumDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album")
    private Integer id;

    @NotNull @NotBlank
    private String nome;

    @OneToMany(mappedBy = "album")
    @JsonManagedReference  // Evitar loop de serialização
    private List<Musica> musicas = new ArrayList<>();

    public List<Musica> getMusicas(){
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Album(AlbumDTO dto) {
        this.id = dto.getId();
        this.nome =dto.getNome();
    }
    public Album() {

    }

    public Album(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(nome, album.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
