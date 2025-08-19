package com.nelioalves.workshop_springboot3_jpa.repositories;

import com.nelioalves.workshop_springboot3_jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
