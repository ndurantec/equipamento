package com.castelo.equipamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castelo.equipamento.repository.ManutencaoRepository;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

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


/*
    @PostMapping(value = "/insert")
    public String insert(){
        return 
}
*/
    
}