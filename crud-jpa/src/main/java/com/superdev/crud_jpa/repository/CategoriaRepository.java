package com.superdev.crud_jpa.repository;

import com.superdev.crud_jpa.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
