package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.ClientDto;
import br.com.digitalhouse.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    // Search All
    @GetMapping
    public ResponseEntity<List<ClientDto>> searchAllClients() {
        List<ClientDto> list = clientService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> searchClientById(@PathVariable Integer id) {
        ClientDto dto = clientService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<ClientDto> insertClient(@RequestBody ClientDto dto) {
        dto = clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Integer id, @RequestBody ClientDto dto) {
        dto = clientService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}