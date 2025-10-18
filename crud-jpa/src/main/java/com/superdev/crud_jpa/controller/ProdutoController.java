package com.superdev.crud_jpa.controller;

import com.superdev.crud_jpa.model.Produto;
import com.superdev.crud_jpa.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable int id) {
        Produto produtoEncontrado = service.findById(id);
        if (produtoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(produtoEncontrado);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(produto));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return ResponseEntity.ok().body(service.save(produto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Produto> delete(@PathVariable int id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/sell/{quantidade}")
    public ResponseEntity<String> sell(
            @RequestBody Produto produto,
            @PathVariable int quantidade) {
        return ResponseEntity.ok().body(service.sell(produto.getId(), quantidade));
    }

    @PutMapping("/buy")
    public ResponseEntity<String> buy(@RequestBody Map<String, Object> parametros) {
        return ResponseEntity.ok().body(service.buy(parametros));
    }

}
