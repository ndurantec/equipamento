package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castelo.equipamento.modelo.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {


    @Query(value = "select * from equipamento where numeracao = ?1", nativeQuery = true)    
    Equipamento findByNumeracao(String numeracao);

}