package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.castelo.equipamento.dto.ManutencaoDto;
import com.castelo.equipamento.modelo.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<ManutencaoDto, Long> {

    void save(Manutencao manutencaoNovo);
  
}