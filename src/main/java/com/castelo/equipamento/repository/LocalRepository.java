package com.castelo.equipamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castelo.equipamento.modelo.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {    

    @Query(value = "select id from lugar where nome = ?1", nativeQuery = true)
    Long findByNome(String nome);

}