package com.castelo.equipamento.controller;

import java.net.URI;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.castelo.equipamento.dto.EquipamentoDto;
import com.castelo.equipamento.modelo.Equipamento;
import com.castelo.equipamento.repository.EquipamentoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Equipamento> cadastrarEquipamento(@RequestBody EquipamentoDto equipamentoDto){

        System.out.println(equipamentoDto.toString());

        Equipamento equipamento = equipamentoDto.novoEquipamento();
        equipamentoRepository.save(equipamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").
                buildAndExpand(equipamento.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(equipamento);
    }

    @GetMapping(value = "/{Id}") 
    public ResponseEntity<Equipamento> findById(@PathVariable Long id){
        return equipamentoRepository.findById(id)
        .map(registro -> ResponseEntity.ok().body(registro))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Equipamento equipamento){

        Optional<Equipamento> equipamentoBanco = equipamentoRepository.findById(null);
        Equipamento equipamentoNovo = equipamentoBanco.get();
        equipamentoNovo.setNome(equipamento.getNome());
        equipamentoRepository.save(equipamentoNovo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        equipamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/findAll")
    public List<Equipamento> Listar(){
        return equipamentoRepository.findAll();
    }
}