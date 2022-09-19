package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Set<ProductDto> products = new HashSet<>();

    public CategoryDto() {
    }

    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        category.getProducts().forEach(product -> this.products.add(new ProductDto(product)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

}