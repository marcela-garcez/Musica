package com.prova.repositories;

import com.prova.domains.Album;
import com.prova.domains.Gravadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GravadoraRepository extends JpaRepository<Gravadora, Integer> {
    Optional<Gravadora> findByCNPJ(String cnpj);
}
