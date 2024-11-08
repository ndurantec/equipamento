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
    public ResponseEntity<Equipamento> cadastrar(@RequestBody EquipamentoDto equipamentoDto){

        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println(equipamentoDto.toString());
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");

        Equipamento equipamento = equipamentoDto.novoEquipamento();

        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println(equipamento.toString());
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");

        equipamentoRepository.save(equipamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
                .buildAndExpand(equipamento.getId())
                    .toUri();

        return ResponseEntity.created(uri).body(equipamento);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipamento> findById(@PathVariable long id ){

        return equipamentoRepository.findById(id)
        .map(registro -> ResponseEntity.ok().body(registro))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Equipamento equipamento){

        Optional<Equipamento> equipamentoBanco = equipamentoRepository.findById(id);
        Equipamento equipamentoObjeto = equipamentoBanco.get();
        equipamentoObjeto.setNome(equipamento.getNome());
        equipamentoRepository.save(equipamentoObjeto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        equipamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/findAll")
    public List<Equipamento> findAll() {

        return equipamentoRepository.findAll();
    }

    @PostMapping("/findByNome")
    public ResponseEntity<Equipamento> buscarEquipamentoPorNome(@RequestBody EquipamentoDto equipamentoDto) {
        //Optional<Local> localBanco = localRepository.findByNome(localDto.getNome());


        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println(equipamentoDto.toString());
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////");


       Equipamento equipamento = equipamentoRepository.findByNome(equipamentoDto.getNome(), equipamentoDto.getNumeracao());
        return ResponseEntity.ok().body(equipamento);
    }
}