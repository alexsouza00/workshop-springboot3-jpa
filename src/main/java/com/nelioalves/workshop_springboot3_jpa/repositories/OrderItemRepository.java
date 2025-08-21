package com.nelioalves.workshop_springboot3_jpa.repositories;

import com.nelioalves.workshop_springboot3_jpa.entities.OrderItem;
import com.nelioalves.workshop_springboot3_jpa.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
