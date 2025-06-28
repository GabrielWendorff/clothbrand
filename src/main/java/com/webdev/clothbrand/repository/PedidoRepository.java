package com.webdev.clothbrand.repository;

import com.webdev.clothbrand.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}