package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.castelo.equipamento.modelo.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    
}
