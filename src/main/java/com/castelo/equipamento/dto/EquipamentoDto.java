package com.castelo.equipamento.dto;

import com.castelo.equipamento.modelo.Equipamento;

public class EquipamentoDto {
    private String nome;
    private LocalDto local;
    private String marca;
    private String status;
    private String numeracao;

    public EquipamentoDto() {
    }

    public EquipamentoDto(String nome, LocalDto local, String marca, String status, String numeracao) {
        this.nome = nome;
        this.local = local;
        this.marca = marca;
        this.status = status;
        this.numeracao = numeracao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDto getLocal() {
        return local;
    }
    public void setLocal(LocalDto local) {
        this.local = local;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    

    
    public String getNumeracao() {
        return numeracao;
    }
    
    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public Equipamento novoEquipamento(){
        return new Equipamento(nome, null, marca, status, numeracao);
    }
}