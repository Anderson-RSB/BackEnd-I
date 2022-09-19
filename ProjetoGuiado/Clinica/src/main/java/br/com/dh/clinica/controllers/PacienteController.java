package br.com.dh.clinica.controllers;

import br.com.dh.clinica.dtos.PacienteDto;
import br.com.dh.clinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscaTodosPacientes() {
        List<PacienteDto> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDto> buscarPacientePorId(@PathVariable Integer id) {
        PacienteDto dto = service.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }


/*    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> buscarEnderecoPorId(@PathVariable Integer id){
        EnderecoDto enderecoDto = service.buscarPorId(id);
        return ResponseEntity.ok().body(enderecoDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> excluirEndereco(@PathVariable Integer id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> inserirEnderecos(@RequestBody EnderecoDto dto){
        dto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoDto dto){
        dto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }*/

}
