package com.nelioalves.workshop_springboot3_jpa.repositories;

import com.nelioalves.workshop_springboot3_jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
