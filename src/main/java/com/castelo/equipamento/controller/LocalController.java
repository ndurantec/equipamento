package com.castelo.equipamento.controller;

import java.net.URI;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalRepository localRepository;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Local> cadastrar(@RequestBody LocalDto localDto){


        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println(localDto.toString());
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");

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

    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Local local){

        Optional<Local> localBanco = localRepository.findById(id);
        
        Local localObjeto = localBanco.get();
        
        localObjeto.setNome(local.getNome());
        
        localRepository.save(localObjeto);
        
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        localRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/findAll")
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    @PostMapping("/findByNome")
    public ResponseEntity<Long> buscarContaPorNome(@RequestBody LocalDto localDto) {
        //Optional<Local> localBanco = localRepository.findByNome(localDto.getNome());
        Long id = localRepository.findByNome(localDto.getNome());
        
        return ResponseEntity.ok().body(id);
    }



}