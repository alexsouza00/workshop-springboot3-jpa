package com.nelioalves.workshop_springboot3_jpa.services;

import com.nelioalves.workshop_springboot3_jpa.entities.Order;
import com.nelioalves.workshop_springboot3_jpa.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){

        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> Order = repository.findById(id);
        return Order.get();
    }
}
