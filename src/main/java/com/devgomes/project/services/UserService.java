package com.devgomes.project.services;

import com.devgomes.project.entities.User;
import com.devgomes.project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }



    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public User insertUser (User user){
        return repository.save(user);
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }

}
