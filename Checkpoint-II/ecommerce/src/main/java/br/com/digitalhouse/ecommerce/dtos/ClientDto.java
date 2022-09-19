package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Address;
import br.com.digitalhouse.ecommerce.entities.Client;

import java.io.Serializable;

public class ClientDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String cpf;
    private String credencial;
    private Address address;

    public ClientDto() {
    }

    public ClientDto(Integer id, String name, String lastname, String email, String cpf, String credencial) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cpf = cpf;
        this.credencial = credencial;
    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.email = client.getEmail();
        this.cpf = client.getCpf();
        this.credencial = client.getCredencial();
        this.address = client.getAddress();
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}