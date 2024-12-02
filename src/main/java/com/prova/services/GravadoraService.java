package com.prova.services;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.domains.Gravadora;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.CantorDTO;
import com.prova.dtos.GravadoraDTO;
import com.prova.repositories.AlbumRepository;
import com.prova.repositories.GravadoraRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GravadoraService {
    @Autowired
    private GravadoraRepository gravadoraRepo;

    public List<GravadoraDTO> findAll(){
        return gravadoraRepo.findAll().stream()
                .map(obj -> new GravadoraDTO(obj))
                .collect(Collectors.toList());
    }
    public Gravadora findbyId(int id){
        Optional<Gravadora> obj = gravadoraRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Gravadora não encontrada! Id: "+id));
    }
    public Gravadora findbyCNPJ(String cnpj){
        Optional<Gravadora> obj = gravadoraRepo.findByCNPJ(cnpj);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Gravadora não encontrada! CNPJ: "+cnpj));
    }
    public Gravadora create(GravadoraDTO dto) {
        dto.setId(null);
        Gravadora obj = new Gravadora(dto);
        return gravadoraRepo.save(obj);
    }
    public Gravadora update(Integer id, GravadoraDTO objDto){
        objDto.setId(id);
        Gravadora oldObj = findbyId(id);
        oldObj = new Gravadora(objDto);
        return gravadoraRepo.save(oldObj);
    }
    public void delete(Integer id){
        Gravadora obj = findbyId(id);
        if(obj.getMusicas().size()>0){
            throw new DataIntegrityViolationException("Gravadora não pode ser deletado, pois possui Musicas vinculadas!");
        }
        gravadoraRepo.deleteById(id);
    }
}
