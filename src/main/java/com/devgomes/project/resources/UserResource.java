package com.devgomes.project.resources;

import com.devgomes.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User (1L, "gomes", "gomes@gmail.com", "9199999999", "gomes232");
        return ResponseEntity.ok().body(u);
    }

}
