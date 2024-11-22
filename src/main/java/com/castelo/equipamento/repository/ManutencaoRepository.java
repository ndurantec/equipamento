package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castelo.equipamento.modelo.Equipamento;
import com.castelo.equipamento.modelo.Local;
import com.castelo.equipamento.modelo.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    @Query(value = "select * from manutencao where local_id = ?1 and equipamento_id = ?2", nativeQuery = true)    
    Manutencao findByNome(Long local_id, Long equipamento_id);
}