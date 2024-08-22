package com.castelo.equipamento.dto;

public class EquipamentoDto {
    private String nome;
    private Local local;
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
    public Local getLocal() {
        return local;
    }
    public void setLocal(Local local) {
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

}
