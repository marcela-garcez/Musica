package com.prova.services;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.CantorDTO;
import com.prova.repositories.AlbumRepository;
import com.prova.repositories.CantorRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CantorService {
    @Autowired
    private CantorRepository cantorRepo;

    public List<CantorDTO> findAll(){
        return cantorRepo.findAll().stream()
                .map(obj -> new CantorDTO(obj))
                .collect(Collectors.toList());
    }
    public Cantor findbyId(int id){
        Optional<Cantor> obj = cantorRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Cantor não encontrado! Id: "+id));
    }
    public Cantor findbyNomeArtistico(String nomeartistico){
        Optional<Cantor> obj = cantorRepo.findByNomeArtistico(nomeartistico);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Cantor não encontrado! Nome Artistico: "+nomeartistico));
    }
    public Cantor create(CantorDTO dto) {
        dto.setId(null);
        Cantor obj = new Cantor(dto);
        return cantorRepo.save(obj);
    }
    public Cantor update(Integer id, CantorDTO objDto){
        objDto.setId(id);
        Cantor oldObj = findbyId(id);
        oldObj = new Cantor(objDto);
        return cantorRepo.save(oldObj);
    }
    public void delete(Integer id){
        Cantor obj = findbyId(id);
        if(obj.getMusicas().size()>0){
            throw new DataIntegrityViolationException("Cantor não pode ser deletado, pois possui Musicas vinculadas!");
        }
        cantorRepo.deleteById(id);
    }
}
