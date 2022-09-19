package br.com.dh.clinica.dtos;

import br.com.dh.clinica.entities.Paciente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PacienteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate datacadastro;
    private Set<EnderecoDto> enderecos = new HashSet<>();

    public PacienteDto() {
    }

    public PacienteDto(Integer id, String nome, String email, String cpf, LocalDate datacadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.datacadastro = datacadastro;
    }

    public PacienteDto(Paciente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.cpf = entidade.getCpf();
        this.datacadastro = entidade.getDataCadastro();
        entidade.getEnderecos().forEach(end -> this.enderecos.add(new EnderecoDto(end)));
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Set<EnderecoDto> getEnderecos() {
        return enderecos;
    }

}
