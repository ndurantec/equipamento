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
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Local local){

        Optional<Local> localBanco = localRepository.findById(null);
        Local localNovo = localBanco.get();
        localNovo.setNome(local.getNome());
        localRepository.save(localNovo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        localRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/findAll")
    public List<Local> findAll() {
        return localRepository.findAll();
    }

    /*
    document.addEventListener("DOMContentLoaded", function() {
  carregarComboLocal();
});


     function carregarComboLocal() {
 
  console.log('Carregou a página e chamou a função');

  var headers = new Headers();    
  headers.append("Content-Type", "application/json");
  headers.append('Access-Control-Allow-Origin', 'http://127.0.0.1:5500');

  fetch('http://127.0.0.1:8080/local/findAll' ,{

    method: "GET",
    mode: "cors", // Usando 'cors' para permitir a requisição de origem cruzada
    cache: "no-cache",
   
    // Convertendo o objeto JavaScript para JSON
    // Esta parte é importante onde você deve passar os parametros (dados) da sua tela

    headers: headers

    
  }).then(response => response.json())
  .then(data => {
      const comboBox = document.getElementById('locais');
      data.forEach(local => {
          const option = document.createElement('option');
          option.value = local.id;
          option.textContent = local.nome;
          comboBox.appendChild(option);
      });
  })
  .catch(error => console.error('Erro ao carregar locais:', error));
   

}





     */





}