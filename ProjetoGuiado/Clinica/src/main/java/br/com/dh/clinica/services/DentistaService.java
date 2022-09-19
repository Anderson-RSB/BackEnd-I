package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.entities.Dentista;
import br.com.dh.clinica.repositories.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository repository;

    @Transactional(readOnly = true)
    public List<DentistaDto> buscarTodos() {
        List<Dentista> list = repository.findAll();
        return list.stream().map(x -> new DentistaDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DentistaDto buscarPorId(Integer id) {
        Optional<Dentista> objeto = repository.findById(id);
        Dentista dentista = objeto.get();
        return new DentistaDto(dentista);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public DentistaDto inserir(DentistaDto dto) {
        Dentista entidade = new Dentista();
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setCro(dto.getCro());
        entidade.setAtendeConvenio(dto.isAtendeconvenio());
        entidade = repository.save(entidade);                // Retorna o objeto com ID
        return new DentistaDto(entidade);
    }

    @Transactional
    public DentistaDto atualizar(Integer id, DentistaDto dto) {
        Dentista entidade = repository.getReferenceById(id);
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setCro(dto.getCro());
        entidade.setAtendeConvenio(dto.isAtendeconvenio());
        entidade = repository.save(entidade);
        return new DentistaDto(entidade);
    }

    // O Transactional garante o bom funcionamento na hora da persistencia de dados
    // para get usa-se o true, pois nenhuma alteração será realizada
}