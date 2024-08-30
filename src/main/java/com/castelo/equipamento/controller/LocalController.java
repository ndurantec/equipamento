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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.castelo.equipamento.dto.LocalDto;
import com.castelo.equipamento.modelo.Local;
import com.castelo.equipamento.repository.LocalRepository;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        return "chegou no servidor";
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<Void> atualizar(){
        System.out.println("atualizando concluída");
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Void> deletar(){
        System.out.println("deletado com sucesso");
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Local>> findAll() {
        List<Local> locais = localRepository.findAll();
        return ResponseEntity.ok(locais);
    }  

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Local> cadastrar(@RequestBody LocalDto localDto){

        Local local = localDto.novoLocal();
        localRepository.save(local);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                    .buildAndExpand(local.getId())
                     .toUri();

        return ResponseEntity.created(uri).body(local);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Local> findById(@PathVariable long id ){
        return localRepository.findById(id)
        .map(registro -> ResponseEntity.ok().body(registro))
        .orElse(ResponseEntity.notFound().build());
    }
}
