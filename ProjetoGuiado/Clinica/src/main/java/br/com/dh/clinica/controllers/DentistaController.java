package br.com.dh.clinica.controllers;

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.services.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/dentistas")
public class DentistaController {

    @Autowired
    DentistaService service;

    @GetMapping
    public ResponseEntity<List<DentistaDto>> buscarTodosDentistas() {
        List<DentistaDto> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DentistaDto> buscarDentistaPorId(@PathVariable Integer id) {
        DentistaDto dentistaDto = service.buscarPorId(id);
        return ResponseEntity.ok().body(dentistaDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirDentista(@PathVariable Integer id) {
        service.excluir(id);
        return ResponseEntity.noContent().build(); // Retorna um código 204
    }

    @PostMapping
    public ResponseEntity<DentistaDto> inserirDentista(@RequestBody DentistaDto dto) {
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DentistaDto> atualizarDentista(@PathVariable Integer id, @RequestBody DentistaDto dto) {
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
