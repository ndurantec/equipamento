package com.castelo.equipamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        return "chegou no servidor";
    }

    @PutMapping(value = "/atualizar")
    public void atualizar(){
        System.out.println("atualização concluida");
    }

    @DeleteMapping(value = "/deletar")
    public void deletar(){
        System.out.println("deletado com sucesso");
    }

    @GetMapping(value = "/findAll")
        public List findAll() {
        return equipamentoRepository.findAll();
    }

    @PostMapping(value = "/cadastrarEquipamento")
    public ResponseEntity<Equipamento> cadastrarEquipamento(@RequestBody EquipamentoDto equipamentoDto){

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


    /*

   
    private ResponseEntity<Equipamento> buscarEquipamento(Equipamento equipamento){



        


        return equipamentoRepository.findById(id)
        .map(registro -> ResponseEntity.ok().body(registro))
        .orElse(ResponseEntity.notFound().build());
    }
    */


}