package com.castelo.equipamento.dto;

import java.sql.Date;

import com.castelo.equipamento.modelo.Equipamento;

public class ManutencaoDto {
     private String local;
    private double telefone;
    private String email;
    private Date data;
    private float custo;
    private Equipamento equipamento;
    private String nome;
    public ManutencaoDto() {
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public double getTelefone() {
        return telefone;
    }
    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public float getCusto() {
        return custo;
    }
    public void setCusto(float custo) {
        this.custo = custo;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
