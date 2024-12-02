package com.prova.resources;



import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.CantorDTO;
import com.prova.services.CantorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cantor")
public class CantorResource {

    @Autowired
    private CantorService cantorService;

    @GetMapping
    public ResponseEntity<List<CantorDTO>> findAll(){
        return ResponseEntity.ok().body(cantorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CantorDTO> findById(@PathVariable int id) {
        Cantor obj = this.cantorService.findbyId(id);
        return ResponseEntity.ok().body(new CantorDTO(obj));
    }
    @GetMapping(value = "/nomeartistico/{nomeartistico}")
    public ResponseEntity<CantorDTO> findById(@PathVariable String nomeartistico){
        Cantor obj =this.cantorService.findbyNomeArtistico(nomeartistico);
        return ResponseEntity.ok().body(new CantorDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CantorDTO> create(@Valid @RequestBody CantorDTO dto){
        Cantor cantor = cantorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cantor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CantorDTO> update(@PathVariable Integer id, @Valid @RequestBody CantorDTO objDto){
        Cantor Obj = cantorService.update(id, objDto);
        return ResponseEntity.ok().body(new CantorDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CantorDTO> delete(@PathVariable Integer id){
        cantorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
