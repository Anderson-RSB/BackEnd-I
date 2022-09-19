package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.EnderecoDto;
import br.com.dh.clinica.entities.Endereco;
import br.com.dh.clinica.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    @Transactional(readOnly = true)
    public List<EnderecoDto> buscarTodos(){
        List<Endereco> list = repository.findAll();
        return list.stream().map(x -> new EnderecoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EnderecoDto buscarPorId(Integer id){
        Optional<Endereco> objeto = repository.findById(id);
        Endereco endereco = objeto.get();
        return new EnderecoDto(endereco);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public EnderecoDto inserir(EnderecoDto dto) {
        Endereco entidade = new Endereco();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);
/*        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
        entidade = repository.save(entidade);                // Retorna o objeto com ID
        return new EnderecoDto(entidade);*/
    }

    @Transactional
    public EnderecoDto atualizar(Integer id, EnderecoDto dto) {
        Endereco entidade = repository.getReferenceById(id);
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);
/*        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);*/
    }

    private void copiarDtoParaEntidade(EnderecoDto dto, Endereco entidade) {
        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
    }

}