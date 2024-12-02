package com.prova.resources;

import com.prova.domains.Album;
import com.prova.domains.Cantor;
import com.prova.domains.Gravadora;
import com.prova.dtos.AlbumDTO;
import com.prova.dtos.CantorDTO;
import com.prova.dtos.GravadoraDTO;
import com.prova.services.GravadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/gravadora")
public class GravadoraResource {

    @Autowired
    private GravadoraService gravadoraService;

    @GetMapping
    public ResponseEntity<List<GravadoraDTO>> findAll(){
        return ResponseEntity.ok().body(gravadoraService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GravadoraDTO> findById(@PathVariable int id) {
        Gravadora obj = this.gravadoraService.findbyId(id);
        return ResponseEntity.ok().body(new GravadoraDTO(obj));
    }
    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<GravadoraDTO> findById(@PathVariable String cnpj){
        Gravadora obj =this.gravadoraService.findbyCNPJ(cnpj);
        return ResponseEntity.ok().body(new GravadoraDTO(obj));
    }
    @PostMapping
    public ResponseEntity<GravadoraDTO> create(@Valid @RequestBody GravadoraDTO dto){
        Gravadora gravadora = gravadoraService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(gravadora.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<GravadoraDTO> update(@PathVariable Integer id, @Valid @RequestBody GravadoraDTO objDto){
        Gravadora Obj = gravadoraService.update(id, objDto);
        return ResponseEntity.ok().body(new GravadoraDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GravadoraDTO> delete(@PathVariable Integer id){
        gravadoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
