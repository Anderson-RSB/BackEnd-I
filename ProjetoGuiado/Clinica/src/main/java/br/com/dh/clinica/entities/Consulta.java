package br.com.dh.clinica.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate datacadastro;
    private LocalDate dataatendimento;
    private Paciente paciente;
    private Dentista dentista;
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;

    public Consulta() {
    }

    public Consulta(Integer id, LocalDate datacadastro, LocalDate dataatendimento, Paciente paciente, Dentista dentista, Usuario usuario) {
        this.id = id;
        this.datacadastro = datacadastro;
        this.dataatendimento = dataatendimento;
        this.paciente = paciente;
        this.dentista = dentista;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return datacadastro;
    }

    public void setDataCadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    public LocalDate getDataAtendimento() {
        return dataatendimento;
    }

    public void setDataAtendimento(LocalDate dataatendimento) {
        this.dataatendimento = dataatendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
