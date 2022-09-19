package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.AddressDto;
import br.com.digitalhouse.ecommerce.entities.Address;
import br.com.digitalhouse.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<AddressDto> searchAll() {
        List<Address> list =  addressRepository.findAll();
        return list.stream().map(x -> new AddressDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public AddressDto searchById(Integer id) {
        Optional<Address> object = addressRepository.findById(id);
        Address entity = object.get();
        return new AddressDto(entity);
    }

    // Insert
    @Transactional
    public AddressDto insert(AddressDto dto) {
        Address entity = new Address();
        copyDtoForEntity(dto, entity);
        entity = addressRepository.save(entity);
        return new AddressDto(entity);
    }

    // Update
    @Transactional
    public AddressDto update(Integer id, AddressDto dto) {
        Address entity = addressRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = addressRepository.save(entity);
        return new AddressDto(entity);
    }

    // Model
    private void copyDtoForEntity(AddressDto dto, Address entity) {
        entity.setCep(dto.getCep());
        entity.setStreet(dto.getStreet());
        entity.setDistrict(dto.getDistrict());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
    }

    // Delete
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

}