package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String cpf;
    private String credencial;

    // Mapeamento de relações
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adrress", referencedColumnName = "id")
    private Address address;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_purchase")
//    private Set<Purchase> purchasing = new HashSet<>();

    // Construtor padrão
    public Client() {
    }

    // Construtor com atributos
    public Client(Integer id, String name, String lastname, String email, String cpf, String credencial) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.cpf = cpf;
        this.credencial = credencial;
    }

    // Getters and Setters
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

//    public Set<Purchase> getPurchasing() {
//        return purchasing;
//    }
//
//    public void setPurchasing(Set<Purchase> purchasing) {
//        this.purchasing = purchasing;
//    }

}