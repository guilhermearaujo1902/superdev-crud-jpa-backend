package com.superdev.crud_jpa.repository;

import com.superdev.crud_jpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT * FROM produto WHERE nome ILIKE %:NOME% ", nativeQuery = true)
    public List<Produto> findByFilterNome(@Param("NOME") String nome);

}
