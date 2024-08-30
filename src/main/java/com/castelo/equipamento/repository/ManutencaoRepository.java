package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelo.equipamento.modelo.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>  {
    
}
