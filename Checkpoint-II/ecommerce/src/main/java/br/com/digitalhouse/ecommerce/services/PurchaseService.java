package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.PurchaseDto;
import br.com.digitalhouse.ecommerce.entities.Purchase;
import br.com.digitalhouse.ecommerce.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<PurchaseDto> searchAll() {
        List<Purchase> list = purchaseRepository.findAll();
        return list.stream().map(x -> new PurchaseDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public PurchaseDto searchById(Integer id) {
        Optional<Purchase> object = purchaseRepository.findById(id);
        Purchase entity = object.get();
        return new PurchaseDto(entity);
    }

    // Insert
    @Transactional
    public PurchaseDto insert(PurchaseDto dto) {
        Purchase entity = new Purchase();
        copyDtoForEntity(dto, entity);
        entity = purchaseRepository.save(entity);
        return new PurchaseDto(entity);
    }

    // Update
    @Transactional
    public PurchaseDto update(Integer id, PurchaseDto dto) {
        Purchase entity = purchaseRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = purchaseRepository.save(entity);
        return new PurchaseDto(entity);
    }

    // Model
    private void copyDtoForEntity(PurchaseDto dto, Purchase entity) {
        entity.setOrdernumber(dto.getOrdernumber());
    }

    // Delete
    public void delete(Integer id) {
        purchaseRepository.deleteById(id);
    }

}