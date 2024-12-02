package com.prova.repositories;

import com.prova.domains.Gravadora;
import com.prova.domains.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Optional<Musica> findByNome(String nome);
}
