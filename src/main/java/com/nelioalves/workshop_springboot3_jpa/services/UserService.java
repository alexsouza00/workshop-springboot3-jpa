package com.nelioalves.workshop_springboot3_jpa.services;

import com.nelioalves.workshop_springboot3_jpa.entities.User;
import com.nelioalves.workshop_springboot3_jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){

        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User updatedUser){
        User user = repository.getReferenceById(id);
        updateUser(updatedUser, user);
        repository.save(user);
        return user;
    }

    public void updateUser(User updatedUser, User user){

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

    }
}
