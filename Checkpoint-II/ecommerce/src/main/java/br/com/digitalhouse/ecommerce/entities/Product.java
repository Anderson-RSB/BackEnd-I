package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String image;

    // Mapeamento de relações
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Category> categories = new HashSet<>();

    // Construtor padrão
    public Product() {
    }

    // Construtor com atributos
    public Product(Integer id, String title, String description, Double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    // Getters and Setters
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

    public Set<Category> getCategories() {
        return categories;
    }

}