package com.nelioalves.workshop_springboot3_jpa.repositories;

import com.nelioalves.workshop_springboot3_jpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
