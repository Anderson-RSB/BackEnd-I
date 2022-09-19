package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.ManagerDto;
import br.com.digitalhouse.ecommerce.entities.Manager;
import br.com.digitalhouse.ecommerce.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<ManagerDto> searchAll() {
        List<Manager> list = managerRepository.findAll();
        return list.stream().map(x -> new ManagerDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public ManagerDto searchById(Integer id) {
        Optional<Manager> object = managerRepository.findById(id);
        Manager entity = object.get();
        return new ManagerDto(entity);
    }

    // Insert
    @Transactional
    public ManagerDto insert(ManagerDto dto) {
        Manager entity = new Manager();
        copyDtoForEntity(dto, entity);
        entity = managerRepository.save(entity);
        return new ManagerDto(entity);
    }

    // Update
    @Transactional
    public ManagerDto update(Integer id, ManagerDto dto) {
        Manager entity = managerRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = managerRepository.save(entity);
        return new ManagerDto(entity);
    }

    // Model
    private void copyDtoForEntity(ManagerDto dto, Manager entity) {
        entity.setUser(dto.getUser());
        entity.setPassword(dto.getPassword());
    }

    // Delete
    public void delete(Integer id) {
        managerRepository.deleteById(id);
    }

}