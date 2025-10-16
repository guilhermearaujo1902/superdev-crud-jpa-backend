package com.superdev.crud_jpa.service;

import com.superdev.crud_jpa.model.Categoria;
import com.superdev.crud_jpa.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        repository = categoriaRepository;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public void delete(Categoria categoria) {
        repository.delete(categoria);
    }

}
