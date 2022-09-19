package br.com.dh.clinica.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Dentista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cro;
    private boolean atendeconvenio;

    public Dentista() {
    }

    public Dentista(Integer id, String nome, String email, String cro, boolean atendeconvenio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cro = cro;
        this.atendeconvenio = atendeconvenio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public boolean isAtendeConvenio() {
        return atendeconvenio;
    }

    public void setAtendeConvenio(boolean atendeconvenio) {
        this.atendeconvenio = atendeconvenio;
    }
}
