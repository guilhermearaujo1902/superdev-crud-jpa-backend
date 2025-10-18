package com.superdev.crud_jpa.repository;

import com.superdev.crud_jpa.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
