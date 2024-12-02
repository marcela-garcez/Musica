package com.prova.resources;

import com.prova.domains.Album;
import com.prova.domains.Gravadora;
import com.prova.domains.Musica;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.GravadoraDTO;
import com.prova.dtos.MusicaDTO;
import com.prova.services.MusicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/musica")
public class MusicaResource {

    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public ResponseEntity<List<MusicaDTO>> findAll(){
        return ResponseEntity.ok().body(musicaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> findById(@PathVariable long id) {
        Musica obj = this.musicaService.findbyId(id);
        return ResponseEntity.ok().body(new MusicaDTO(obj));
    }
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<MusicaDTO> findById(@PathVariable String nome){
        Musica obj =this.musicaService.findbyNome(nome);
        return ResponseEntity.ok().body(new MusicaDTO(obj));
    }
    @PostMapping
    public ResponseEntity<MusicaDTO> create(@Valid @RequestBody MusicaDTO dto){
        Musica musica = musicaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(musica.getIdMusica()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> update(@PathVariable Long id, @Valid @RequestBody MusicaDTO objDto){
        Musica Obj = musicaService.update(id, objDto);
        return ResponseEntity.ok().body(new MusicaDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> delete(@PathVariable Long id){
        musicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
