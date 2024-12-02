package com.prova.resources;

import com.prova.domains.Album;
import com.prova.dtos.AlbumDTO;
import com.prova.repositories.AlbumRepository;
import com.prova.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> findAll() {
        return ResponseEntity.ok().body(albumService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlbumDTO> findById(@PathVariable int id) {
        Album obj = this.albumService.findbyId(id);
        return ResponseEntity.ok().body(new AlbumDTO(obj));
    }
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<AlbumDTO> findById(@PathVariable String nome){
        Album obj =this.albumService.findbyNome(nome);
        return ResponseEntity.ok().body(new AlbumDTO(obj));
    }
    @PostMapping
    public ResponseEntity<AlbumDTO> create(@Valid @RequestBody AlbumDTO dto){
        Album album = albumService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(album.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AlbumDTO> update(@PathVariable Integer id, @Valid @RequestBody AlbumDTO objDto){
        Album Obj = albumService.update(id, objDto);
        return ResponseEntity.ok().body(new AlbumDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlbumDTO> delete(@PathVariable Integer id){
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }


}