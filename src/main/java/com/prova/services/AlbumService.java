package com.prova.services;

import com.prova.domains.Album;
import com.prova.dtos.AlbumDTO;
import com.prova.repositories.AlbumRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepo;

    public List<AlbumDTO> findAll() {
        return albumRepo.findAll().stream()
                .map(obj -> new AlbumDTO(obj))
                .collect(Collectors.toList());
    }

    public Album findbyId(int id) {
        Optional<Album> obj = albumRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Album não encontrado! Id: " + id));
    }

    public Album findbyNome(String nome) {
        Optional<Album> obj = albumRepo.findByNome(nome);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Album não encontrado! Nome: " + nome));
    }

    public Album create(AlbumDTO dto) {
        dto.setId(null);
        Album obj = new Album(dto);
        return albumRepo.save(obj);
    }

    public Album update(Integer id, AlbumDTO objDto) {
        objDto.setId(id);
        Album oldObj = findbyId(id);
        oldObj = new Album(objDto);
        return albumRepo.save(oldObj);
    }

    public void delete(Integer id) {
        Album obj = findbyId(id);
        if (obj.getMusicas().size() > 0) {
            throw new DataIntegrityViolationException("Album não pode ser deletado, pois possui Musicas vinculadas!");
        }
        albumRepo.deleteById(id);
    }

    }
