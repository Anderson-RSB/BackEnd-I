package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.HarmonyDto;
import br.com.digitalhouse.ecommerce.entities.Harmony;
import br.com.digitalhouse.ecommerce.repositories.HarmonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HarmonyService {

    @Autowired
    private HarmonyRepository harmonyRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<HarmonyDto> searchAll() {
        List<Harmony> list = harmonyRepository.findAll();
        return list.stream().map(x -> new HarmonyDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public HarmonyDto searchById(Integer id) {
        Optional<Harmony> object = harmonyRepository.findById(id);
        Harmony entity = object.get();
        return new HarmonyDto(entity);
    }

    // Insert
    @Transactional
    public HarmonyDto insert(HarmonyDto dto) {
        Harmony entity = new Harmony();
        copyDtoForEntity(dto, entity);
        entity = harmonyRepository.save(entity);
        return new HarmonyDto(entity);
    }

    // Update
    @Transactional
    public HarmonyDto update(Integer id, HarmonyDto dto) {
        Harmony entity = harmonyRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = harmonyRepository.save(entity);
        return new HarmonyDto(entity);
    }

    // Model
    private void copyDtoForEntity(HarmonyDto dto, Harmony entity) {
        entity.setNamePlate(dto.getNameplate());
    }

    // Delete
    public void delete(Integer id) {
        harmonyRepository.deleteById(id);
    }

}