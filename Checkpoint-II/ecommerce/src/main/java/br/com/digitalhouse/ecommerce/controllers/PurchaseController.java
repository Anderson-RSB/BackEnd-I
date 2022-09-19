package br.com.digitalhouse.ecommerce.controllers;

import br.com.digitalhouse.ecommerce.dtos.PurchaseDto;
import br.com.digitalhouse.ecommerce.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/purchasing")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    // Search All
    @GetMapping
    public ResponseEntity<List<PurchaseDto>> searchAllPurchasing() {
        List<PurchaseDto> list = purchaseService.searchAll();
        return ResponseEntity.ok().body(list);
    }

    // Search By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PurchaseDto> searchPurchaseById(@PathVariable Integer id) {
        PurchaseDto dto = purchaseService.searchById(id);
        return ResponseEntity.ok().body(dto);
    }

    // Insert
    @PostMapping
    public ResponseEntity<PurchaseDto> insertPurchase(@RequestBody PurchaseDto dto) {
        dto = purchaseService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    // Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<PurchaseDto> updatePurchase(@PathVariable Integer id, @RequestBody PurchaseDto dto) {
        dto = purchaseService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    // Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Integer id) {
        purchaseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}