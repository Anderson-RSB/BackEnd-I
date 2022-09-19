package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Grape implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String namegrape;

    // Mapeamento de relações
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "grape_harmony",
        joinColumns = @JoinColumn(name = "id_grape"),
        inverseJoinColumns = @JoinColumn(name = "id_harmony"))
    private Set<Harmony> harmonies = new HashSet<>();

    // Construtor padrão
    public Grape() {
    }

    // Construtor com atributos
    public Grape(Integer id, String namegrape) {
        this.id = id;
        this.namegrape = namegrape;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGrape() {
        return namegrape;
    }

    public void setNameGrape(String namegrape) {
        this.namegrape = namegrape;
    }

    public Set<Harmony> getHarmonies() {
        return harmonies;
    }

}