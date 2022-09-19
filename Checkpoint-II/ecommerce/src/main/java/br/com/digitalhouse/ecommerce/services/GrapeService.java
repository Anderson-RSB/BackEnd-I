package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.GrapeDto;
import br.com.digitalhouse.ecommerce.dtos.HarmonyDto;
import br.com.digitalhouse.ecommerce.entities.Grape;
import br.com.digitalhouse.ecommerce.entities.Harmony;
import br.com.digitalhouse.ecommerce.repositories.GrapeRepository;
import br.com.digitalhouse.ecommerce.repositories.HarmonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrapeService {

    @Autowired
    private GrapeRepository grapeRepository;

    @Autowired
    private HarmonyRepository harmonyRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<GrapeDto> searchAll() {
        List<Grape> list = grapeRepository.findAll();
        return list.stream().map(x -> new GrapeDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public GrapeDto searchById(Integer id) {
        Optional<Grape> object = grapeRepository.findById(id);
        Grape entity = object.get();
        return new GrapeDto(entity);
    }

    // Insert
    @Transactional
    public GrapeDto insert(GrapeDto dto) {
        Grape entity = new Grape();
        copyDtoForEntity(dto, entity);
        entity = grapeRepository.save(entity);
        return new GrapeDto(entity);
    }

    // Update
    @Transactional
    public GrapeDto update(Integer id, GrapeDto dto) {
        Grape entity = grapeRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = grapeRepository.save(entity);
        return new GrapeDto(entity);
    }

    // Model
    private void copyDtoForEntity(GrapeDto dto, Grape entity) {
        entity.setNameGrape(dto.getNamegrape());

        entity.getHarmonies().clear();
        for (HarmonyDto harmonyDto : dto.getHarmonies()) {
            Harmony harmony = harmonyRepository.getReferenceById(harmonyDto.getId());
            entity.getHarmonies().add(harmony);
        }
    }

    // Delete
    public void delete(Integer id) {
        grapeRepository.deleteById(id);
    }

}