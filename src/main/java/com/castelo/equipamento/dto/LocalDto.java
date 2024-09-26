package com.castelo.equipamento.dto;

import com.castelo.equipamento.modelo.Local;

public class LocalDto {

    private Long id;
    private String nome;

    public LocalDto() {
    }

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local novoLocal(){
        return new Local(id, nome);
    }


}
