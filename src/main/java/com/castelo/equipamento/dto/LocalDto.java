package com.castelo.equipamento.dto;

import com.castelo.equipamento.modelo.Local;

public class LocalDto {

    private String nome;

    public LocalDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local novoLocal(){
        return new Local(null, nome);
    }
}
