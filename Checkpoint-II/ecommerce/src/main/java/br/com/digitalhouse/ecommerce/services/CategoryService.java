package br.com.digitalhouse.ecommerce.services;

import br.com.digitalhouse.ecommerce.dtos.CategoryDto;
import br.com.digitalhouse.ecommerce.dtos.ProductDto;
import br.com.digitalhouse.ecommerce.entities.Category;
import br.com.digitalhouse.ecommerce.entities.Product;
import br.com.digitalhouse.ecommerce.repositories.CategoryRepository;
import br.com.digitalhouse.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<CategoryDto> searchAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public CategoryDto searchById(Integer id) {
        Optional<Category> object = categoryRepository.findById(id);
        Category entity = object.get();
        return new CategoryDto(entity);
    }

    // Insert
    @Transactional
    public CategoryDto insert(CategoryDto dto) {
        Category entity = new Category();
        copyDtoForEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    // Update
    @Transactional
    public CategoryDto update(Integer id, CategoryDto dto) {
        Category entity = categoryRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    // Model
    private void copyDtoForEntity(CategoryDto dto, Category entity) {
        entity.setName(dto.getName());

        entity.getProducts().clear();
        for (ProductDto productDto : dto.getProducts()) {
            Product product = productRepository.getReferenceById(productDto.getId());
            entity.getProducts().add(product);
        }
    }

    // Delete
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

}