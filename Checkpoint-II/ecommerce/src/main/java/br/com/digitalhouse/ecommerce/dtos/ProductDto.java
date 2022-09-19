package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String image;

    private Set<CategoryDto> categories = new HashSet<>();

    public ProductDto() {
    }

    public ProductDto(Integer id, String title, String description, Double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.image = product.getImage();
        product.getCategories().forEach(category -> this.categories.add(new CategoryDto(category)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

}