package com.castelo.equipamento.dto;

import java.sql.Date;

import com.castelo.equipamento.modelo.Equipamento;
import com.castelo.equipamento.modelo.Manutencao;

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
    public Manutencao novaManutencao(){
           return new Manutencao(local, telefone, email, data, custo, equipamento, nome);
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((custo == null) ? 0 : custo.hashCode());
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ManutencaoDto other = (ManutencaoDto) obj;
        
        if (nome == null) {
            if (other.nome != null) return false;
        } else if (!nome.equals(other.nome)) return false;
    
        if (custo == null) {
            if (other.custo != null) return false;
        } else if (!custo.equals(other.custo)) return false;
    
        if (local == null) {
            if (other.local != null) return false;
        } else if (!local.equals(other.local)) return false;
    
        if (equipamento == null) {
            if (other.equipamento != null) return false;
        } else if (!equipamento.equals(other.equipamento)) return false;
    
        if (telefone == null) {
            if (other.telefone != null) return false;
        } else if (!telefone.equals(other.telefone)) return false;
    
        if (email == null) {
            if (other.email != null) return false;
        } else if (!email.equals(other.email)) return false;
    
        if (data == null) {
            if (other.data != null) return false;
        } else if (!data.equals(other.data)) return false;
    
        return true;
    }
}