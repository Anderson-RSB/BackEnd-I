package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Manager;

import java.io.Serializable;

public class ManagerDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String user;
    private String password;

    public ManagerDto() {
    }

    public ManagerDto(Integer id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public ManagerDto(Manager manager) {
        this.id = manager.getId();
        this.user = manager.getUser();
        this.password = manager.getPassword();
    }

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