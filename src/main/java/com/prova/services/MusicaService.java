package com.prova.services;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.domains.Gravadora;
import com.prova.domains.Musica;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.CantorDTO;
import com.prova.dtos.MusicaDTO;
import com.prova.repositories.AlbumRepository;
import com.prova.repositories.MusicaRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepo;

    public List<MusicaDTO> findAll(){
        return musicaRepo.findAll().stream()
                .map(obj -> new MusicaDTO(obj))
                .collect(Collectors.toList());
    }
    public Musica findbyId(Long id){
        Optional<Musica> obj = musicaRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Musica não encontrada! Id: "+id));
    }
    public Musica findbyNome(String nome){
        Optional<Musica> obj = musicaRepo.findByNome(nome);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Musica não encontrada! Nome: "+nome));
    }
    public Musica create(MusicaDTO dto) {
        dto.setIdMusica(null);
        Musica obj = new Musica(dto);
        return musicaRepo.save(obj);
    }
    public Musica update(Long id, MusicaDTO objDto){
        objDto.setIdMusica(id);
        Musica oldObj = findbyId(id);
        oldObj = new Musica(objDto);
        return musicaRepo.save(oldObj);
    }
    public void delete(Long id){
        Musica obj = findbyId(id);
        musicaRepo.deleteById(id);
    }
}
