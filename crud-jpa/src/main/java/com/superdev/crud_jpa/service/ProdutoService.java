package com.superdev.crud_jpa.service;

import com.superdev.crud_jpa.model.Produto;
import com.superdev.crud_jpa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService (ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public boolean delete(int id) {
        Produto produtoEncontrado = this.findById(id);
        if (produtoEncontrado == null) {
            return false;
        }
        repository.delete(produtoEncontrado);
        return true;
    }

    public String sell(int id, int quantidade) {
        Produto produtoAtual = this.findById(id);

        if (produtoAtual == null) {
            return "Produto não encontrado para o código " + id;
        }

        int estoqueFinal = produtoAtual.getQuantidade() - quantidade;

        if (estoqueFinal < 0) {
            return "Não é possível realizar a venda de " + quantidade + " unidades" +
                    "\nEstoque atual: " + produtoAtual.getQuantidade();
        }

        produtoAtual.setQuantidade(estoqueFinal);
        this.save(produtoAtual);
        return "Venda realizada com sucesso. Estoque atualizado: " + produtoAtual.getQuantidade();
    }

    public String buy(Map<String, Object> parametros) {

        // Mapeando as chaves, ou nomes de propriedades, existentes no Mapa de objetos (ou Map)
        int id = (Integer) parametros.get("id");
        int quantidade = (Integer) parametros.get("quantidade");

        Produto produtoAtual = this.findById(id);

        if (produtoAtual == null) {
            return "Produto não encontrado para o código " + id;
        }

        int estoqueFinal = produtoAtual.getQuantidade() + quantidade;
        produtoAtual.setQuantidade(estoqueFinal);
        this.save(produtoAtual);
        return "Compra realizada com sucesso. Estoque atualizado: " + produtoAtual.getQuantidade();
    }

}
