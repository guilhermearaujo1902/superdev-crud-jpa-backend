package com.superdev.crud_jpa.controller;

import com.superdev.crud_jpa.model.Categoria;
import com.superdev.crud_jpa.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/all")
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable int id) {
        Categoria categoriaEncontrada = categoriaService.findById(id);
        if (categoriaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaEncontrada);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Categoria> insert(@RequestBody Categoria novaCategoria) {
        return ResponseEntity.ok(categoriaService.save(novaCategoria));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Categoria> update(
            @PathVariable int id,
            @RequestBody Categoria categoria) {
        Categoria categoriaEncontrada = categoriaService.findById(id);
        if (categoriaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable int id) {
        Categoria categoriaEncontrada = categoriaService.findById(id);
        if (categoriaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.delete(categoriaEncontrada);
        return ResponseEntity.ok(categoriaEncontrada);
    }

}
