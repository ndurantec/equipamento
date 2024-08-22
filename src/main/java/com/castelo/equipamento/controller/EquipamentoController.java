package com.castelo.equipamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @GetMapping(value = "/imprimir")
    public void imprimir(){
        System.out.println("chegou no servidor");
    }
}
