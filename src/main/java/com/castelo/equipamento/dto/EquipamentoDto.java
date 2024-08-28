package com.castelo.equipamento.dto;

import com.castelo.equipamento.modelo.Equipamento;

public class EquipamentoDto {
    private String nome;
    private LocalDto local;
    private String marca;
    private boolean status;
    private int numeracao;

    public EquipamentoDto() {
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
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getNumeracao() {
        return numeracao;
    }
    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }
       
    public Equipamento novoEquipamento(){
        return new Equipamento(nome, null, marca, status, numeracao);
    }
}