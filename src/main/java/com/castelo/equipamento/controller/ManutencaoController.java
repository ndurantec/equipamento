package com.castelo.equipamento.controller;

import java.net.URI;
import java.util.Optional;

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

import com.castelo.equipamento.dto.ManutencaoDto;
import com.castelo.equipamento.modelo.Manutencao;
import com.castelo.equipamento.repository.ManutencaoRepository;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Manutencao> findById(@PathVariable long id ){
        return manutencaoRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
                .orElse(ResponseEntity.notFound().build());
    }

     @PutMapping (value = "/{id}")
     public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Manutencao manutencao){

        Optional<Manutencao> manutencaoBanco = manutencaoRepository.findById(null);
        Manutencao manutencaoNovo = manutencaoBanco.get();
        manutencaoNovo.setNome(manutencao.getNome());
        manutencaoRepository.save(manutencaoNovo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
      manutencaoRepository.deleteById(id);
      return   ResponseEntity.noContent().build();
    }
}