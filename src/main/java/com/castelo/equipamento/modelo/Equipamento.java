package com.castelo.equipamento.modelo;

public class Equipamento {
    
    String nome;
    Local local;
    String marca;
    boolean status;
    int numeracao;

    public Equipamento() {
    }

    public Equipamento(String nome, String marca, boolean status, int numeracao) {
        this.nome = nome;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + (status ? 1231 : 1237);
        result = prime * result + numeracao;
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
        Equipamento other = (Equipamento) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (status != other.status)
            return false;
        if (numeracao != other.numeracao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Equipamento [nome=" + nome + ", marca=" + marca + ", status=" + status + ", numeracao=" + numeracao
                + "]";
    }
}
