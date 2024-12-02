package com.prova.repositories;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CantorRepository extends JpaRepository<Cantor, Integer> {
    Optional<Cantor> findByNomeArtistico(String nomeartistico);
}
