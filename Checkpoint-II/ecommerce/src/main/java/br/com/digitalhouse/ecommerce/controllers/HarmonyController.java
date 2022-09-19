package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.HarmonyDto;
import br.com.digitalhouse.ecommerce.services.HarmonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/harmonies")
public class HarmonyController {

    @Autowired
    HarmonyService harmonyService;

    // Search All
    @GetMapping
    public ResponseEntity<List<HarmonyDto>> searchAllHarmonies() {
        List<HarmonyDto> list = harmonyService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<HarmonyDto> searchHarmonyById(@PathVariable Integer id) {
        HarmonyDto dto = harmonyService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<HarmonyDto> insertHarmony(@RequestBody HarmonyDto dto) {
        dto = harmonyService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<HarmonyDto> updateHarmony(@PathVariable Integer id, @RequestBody HarmonyDto dto) {
        dto = harmonyService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteHarmony(@PathVariable Integer id) {
        harmonyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}