package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.ClientDto;
import br.com.digitalhouse.ecommerce.entities.Client;
import br.com.digitalhouse.ecommerce.repositories.AddressRepository;
import br.com.digitalhouse.ecommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<ClientDto> searchAll() {
        List<Client> list = clientRepository.findAll();
        return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public ClientDto searchById(Integer id) {
        Optional<Client> object = clientRepository.findById(id);
        Client entity = object.get();
        return new ClientDto(entity);
    }

    // Insert
    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client entity = new Client();
        copyDtoForEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDto(entity);
    }

    // Update
    @Transactional
    public ClientDto update(Integer id, ClientDto dto) {
        Client entity = clientRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDto(entity);
    }

    // Model
    private void copyDtoForEntity(ClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setEmail(dto.getEmail());
        entity.setCpf(dto.getCpf());
        entity.setCredencial(dto.getCredencial());
        entity.setAddress(dto.getAddress());
    }

    // Delete
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

}