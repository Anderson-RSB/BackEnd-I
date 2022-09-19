package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.GrapeDto;
import br.com.digitalhouse.ecommerce.services.GrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/grapes")
public class GrapeController {

    @Autowired
    GrapeService grapeService;

    // Search All
    @GetMapping
    public ResponseEntity<List<GrapeDto>> searchAllGrapes() {
        List<GrapeDto> list = grapeService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<GrapeDto> searchGrapeById(@PathVariable Integer id) {
        GrapeDto dto = grapeService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<GrapeDto> insertGrape(@RequestBody GrapeDto dto) {
        dto = grapeService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<GrapeDto> updateGrape(@PathVariable Integer id, @RequestBody GrapeDto dto) {
        dto = grapeService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteGrape(@PathVariable Integer id) {
        grapeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}