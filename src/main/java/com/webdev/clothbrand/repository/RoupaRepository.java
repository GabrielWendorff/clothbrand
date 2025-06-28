package com.webdev.clothbrand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdev.clothbrand.model.Roupa;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa, Long> {
}