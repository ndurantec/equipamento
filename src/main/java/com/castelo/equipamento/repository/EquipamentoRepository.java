package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castelo.equipamento.modelo.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {


    @Query("select * from equipamento where numeracao like ? ")    
    Equipamento findByNumeracao(String numeracao);

}