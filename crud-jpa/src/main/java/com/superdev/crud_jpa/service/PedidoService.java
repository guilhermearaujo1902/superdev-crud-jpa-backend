package com.superdev.crud_jpa.service;

import com.superdev.crud_jpa.model.Pedido;
import com.superdev.crud_jpa.repository.CategoriaRepository;
import com.superdev.crud_jpa.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository pedidoRepository){
        repository = pedidoRepository;
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    public void delete(Pedido pedido) {
        repository.delete(pedido);
    }


}
