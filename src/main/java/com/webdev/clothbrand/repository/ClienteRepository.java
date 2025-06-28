package com.webdev.clothbrand.repository;

import com.webdev.clothbrand.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}