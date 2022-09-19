package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String street;
    private String district;
    private String city;
    private String state;
    private String country;

    // Construtor padrão
    public Address() {
    }

    // Construtor com atributos
    public Address(Integer id, String cep, String street, String district, String city, String state, String country) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
