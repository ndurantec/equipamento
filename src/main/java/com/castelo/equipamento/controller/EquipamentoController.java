package com.castelo.equipamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        return "chegou no servidor";
    }
}
