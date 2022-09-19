package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.ManagerDto;
import br.com.digitalhouse.ecommerce.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/managers")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    // Search All
    @GetMapping
    public ResponseEntity<List<ManagerDto>> searchAllManagers() {
        List<ManagerDto> list = managerService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ManagerDto> searchManagerById(@PathVariable Integer id) {
        ManagerDto dto = managerService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<ManagerDto> insertManager(@RequestBody ManagerDto dto) {
        dto = managerService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<ManagerDto> updateManager(@PathVariable Integer id, @RequestBody ManagerDto dto) {
        dto = managerService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Integer id) {
        managerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}