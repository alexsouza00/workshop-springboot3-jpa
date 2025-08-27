package com.nelioalves.workshop_springboot3_jpa.resources;

import com.nelioalves.workshop_springboot3_jpa.entities.User;
import com.nelioalves.workshop_springboot3_jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


//classe para controlar as requisições http, chamando o service
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //metodo http post
    @PostMapping
    //ele precisa de um json no body que seja do tipo User
    public ResponseEntity<User> insert(@RequestBody User obj) {
        //aqui ele esta adicionando o objeto fornecido no banco de dados
         service.insert(obj);
        //estamos pegando o endereço
        //ele começa chamando uma classe para construir a uri e depois um
        // metodo para pegar o caminho em que a requisição foi feita, depois ele cria uma
        // viariavel temporaria com o id que vai ser definido posteriormente no proximo metodo
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
