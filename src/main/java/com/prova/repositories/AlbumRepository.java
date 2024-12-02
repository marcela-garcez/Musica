package com.prova.repositories;

import com.prova.domains.Album;
import com.prova.dtos.AlbumDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
Optional<Album> findByNome(String nome);
}