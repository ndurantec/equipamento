package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castelo.equipamento.modelo.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {
    
}
