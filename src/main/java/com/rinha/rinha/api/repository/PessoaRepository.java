package com.rinha.rinha.api.repository;

import com.rinha.rinha.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    @Query(value= "SELECT * FROM PESSOA WHERE TERMO ~* ?1 LIMIT 50", nativeQuery = true)
    List<Pessoa> findByTermo(String termo);
}