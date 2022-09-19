package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Address;

import java.io.Serializable;

public class AddressDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cep;
    private String street;
    private String district;
    private String city;
    private String state;
    private String country;

    public AddressDto() {
    }

    public AddressDto(Integer id, String cep, String street, String district, String city, String state, String country) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public AddressDto(Address address) {
        this.id = address.getId();
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
    }

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