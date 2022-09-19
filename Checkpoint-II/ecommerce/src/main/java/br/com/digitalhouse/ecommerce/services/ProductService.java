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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Search All
    @Transactional(readOnly = true)
    public List<ProductDto> searchAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
    }

    // Search By Id
    @Transactional(readOnly = true)
    public ProductDto  searchById(Integer id) {
        Optional<Product> object = productRepository.findById(id);
        Product entity = object.get();
        return new ProductDto(entity);
    }

    // Insert
    @Transactional
    public ProductDto insert(ProductDto dto) {
        Product entity = new Product();
        copyDtoForEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDto(entity);
    }

    // Update
    @Transactional
    public ProductDto update(Integer id, ProductDto dto) {
        Product entity = productRepository.getReferenceById(id);
        copyDtoForEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDto(entity);
    }

    // Model
    private void copyDtoForEntity(ProductDto dto, Product entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setPrice(dto.getPrice());

        entity.getCategories().clear();
        for (CategoryDto categoryDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(categoryDto.getId());
            entity.getCategories().add(category);
        }
    }

    // Delete
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}