package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.AddressDto;
import br.com.digitalhouse.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    // Search All
    @GetMapping
    public ResponseEntity<List<AddressDto>> searchAllAddress() {
        List<AddressDto> list = addressService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> searchAddressById(@PathVariable Integer id) {
        AddressDto dto = addressService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<AddressDto> insertAddress(@RequestBody AddressDto dto) {
        dto = addressService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Integer id, @RequestBody AddressDto dto) {
        dto = addressService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

}