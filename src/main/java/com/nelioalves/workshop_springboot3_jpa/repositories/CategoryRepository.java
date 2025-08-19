package com.nelioalves.workshop_springboot3_jpa.repositories;

import com.nelioalves.workshop_springboot3_jpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
