package br.com.digitalhouse.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user;
    private String password;

    // Construtor padrão
    public Manager() {
    }

    // Construtor com atributos
    public Manager(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}