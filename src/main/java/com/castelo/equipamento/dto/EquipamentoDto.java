package com.castelo.equipamento.dto;

import com.castelo.equipamento.modelo.Equipamento;
import com.castelo.equipamento.modelo.Local;

public class EquipamentoDto {

    private Long id;
    private String nome;
    private Local local;
    private String marca;
    private String status;
    private String numeracao;

    public EquipamentoDto() {
    }

    public EquipamentoDto(String nome, Local local, String marca, String status, String numeracao) {
        this.nome = nome;
        this.local = local;
        this.marca = marca;
        this.status = status;
        this.numeracao = numeracao;
    }
    
    public Equipamento novoEquipamento(){
        return new Equipamento(nome, local, marca, status, numeracao);
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((numeracao == null) ? 0 : numeracao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EquipamentoDto other = (EquipamentoDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (numeracao == null) {
            if (other.numeracao != null)
                return false;
        } else if (!numeracao.equals(other.numeracao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EquipamentoDto [id=" + id + ", nome=" + nome + ", local=" + local + ", marca=" + marca + ", status="
                + status + ", numeracao=" + numeracao + "]";
    }
}