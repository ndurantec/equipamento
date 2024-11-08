package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castelo.equipamento.modelo.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

        @Query(value = "select id from manutencao where email = ?1", nativeQuery = true)    
    Long findByNome(String email);
}