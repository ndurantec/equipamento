package com.castelo.equipamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.castelo.equipamento.dto.ManutencaoDto;
import com.castelo.equipamento.modelo.Manutencao;
import com.castelo.equipamento.repository.ManutencaoRepository;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    private static final Object Manutencao = null;
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        return "chegou no servidor";
    }

    @PostMapping(value = "/cadastrar")
    public void cadastrar(){
        System.out.println("cadastrou com sucesso");
    }

    @PutMapping(value = "/atualizar")
    public void atualizar(){
        System.out.println("atualização concluida");
    }

    @DeleteMapping(value = "/deletar")
    public void deletar(){
        System.out.println("deletado com sucesso");
    }

    @GetMapping
    public List findAll(){
        return manutencaoRepository.findAll();
    }



    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Manutencao> cadastrar(@RequestBody ManutencaoDto manutencaoDto){
        Manutencao manutencao = manutencaoDto.novaManutencao();
        manutencaoRepository.save(manutencao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}") 
                .buildAndExpand(manutencao.getId())
                    .toUri();

        
        return ResponseEntity.created(uri).body(manutencao);
}

    
}