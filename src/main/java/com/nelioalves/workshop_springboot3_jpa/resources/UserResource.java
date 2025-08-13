package com.nelioalves.workshop_springboot3_jpa.resources;

import com.nelioalves.workshop_springboot3_jpa.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1, "Alex", "alex@gmail.com", "12345", "123");
        return ResponseEntity.ok().body(user);
    }

}
