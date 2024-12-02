package com.prova.dtos;

import com.prova.domains.Album;
import com.prova.domains.Musica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    private List<String> musicas;

    public AlbumDTO() {
    }

    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.nome = album.getNome();
        this.musicas = album.getMusicas().stream()
                .map(Musica::getNome) // Extrai o nome das músicas
                .collect(Collectors.toList());
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

    public List<String> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<String> musicas) {
        this.musicas = musicas;
    }
}
