package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Harmony implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameplate;

    // Construtor padrão
    public Harmony() {
    }

    // Construtor com atributos
    public Harmony(Integer id, String nameplate) {
        this.id = id;
        this.nameplate = nameplate;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePlate() {
        return nameplate;
    }

    public void setNamePlate(String nameplate) {
        this.nameplate = nameplate;
    }

}