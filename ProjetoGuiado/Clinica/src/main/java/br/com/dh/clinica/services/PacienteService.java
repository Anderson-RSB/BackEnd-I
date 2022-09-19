package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.PacienteDto;
import br.com.dh.clinica.entities.Paciente;
import br.com.dh.clinica.repositories.EnderecoRepository;
import br.com.dh.clinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<PacienteDto> buscarTodos(){
        List<Paciente> list = pacienteRepository.findAll();
        return list.stream().map(x -> new PacienteDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PacienteDto buscarPorId(Integer id) {
        Optional<Paciente> objeto = pacienteRepository.findById(id);
        Paciente entidade = objeto.get();
        return new PacienteDto(entidade);
    }


/*    @Transactional(readOnly = true)
    public PacienteDto buscarPorId(Integer id){
        Optional<Paciente> objeto = pacienteRepository.findById(id);
        Paciente paciente = objeto.get();
        return new PacienteDto(paciente);
    }

    public void excluir(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Transactional
    public PacienteDto inserir(PacienteDto dto) {
        Paciente entidade = new Paciente();
        copiarDtoParaEntidade(dto, entidade);
        entidade = pacienteRepository.save(entidade);
        return new PacienteDto(entidade);
*//*        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
        entidade = repository.save(entidade);                // Retorna o objeto com ID
        return new EnderecoDto(entidade);*//*
    }

    @Transactional
    public EnderecoDto atualizar(Integer id, EnderecoDto dto) {
        Endereco entidade = repository.getReferenceById(id);
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);
*//*        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);*//*
    }

    private void copiarDtoParaEntidade(EnderecoDto dto, Endereco entidade) {
        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
    }*/

}