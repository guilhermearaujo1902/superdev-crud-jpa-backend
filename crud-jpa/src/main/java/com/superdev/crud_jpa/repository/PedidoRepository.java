package com.superdev.crud_jpa.repository;

import com.superdev.crud_jpa.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
