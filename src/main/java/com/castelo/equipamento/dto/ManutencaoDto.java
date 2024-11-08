package com.castelo.equipamento.dto;

import java.sql.Date;

import com.castelo.equipamento.modelo.Equipamento;
import com.castelo.equipamento.modelo.Local;
import com.castelo.equipamento.modelo.Manutencao;

public class ManutencaoDto {

    private Long id;
    private Local local;
    private String telefone;
    private String email;
    private Date data;
    private Double custo;
    private Equipamento equipamento;
    private String nome;
    
    public ManutencaoDto() {
    }

    public ManutencaoDto(Local local, String telefone, String email, Date data, Double custo, Equipamento equipamento,
            String nome) {
        this.local = local;
        this.telefone = telefone;
        this.email = email;
        this.data = data;
        this.custo = custo;
        this.equipamento = equipamento;
        this.nome = nome;
    }

    public Manutencao novoManutencao(){
        return new Manutencao(id, local, telefone, email, data, 0, equipamento, nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((custo == null) ? 0 : custo.hashCode());
        result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        ManutencaoDto other = (ManutencaoDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (custo == null) {
            if (other.custo != null)
                return false;
        } else if (!custo.equals(other.custo))
            return false;
        if (equipamento == null) {
            if (other.equipamento != null)
                return false;
        } else if (!equipamento.equals(other.equipamento))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ManutencaoDto [id=" + id + ", local=" + local + ", telefone=" + telefone + ", email=" + email
                + ", data=" + data + ", custo=" + custo + ", equipamento=" + equipamento + ", nome=" + nome + "]";
    }
}