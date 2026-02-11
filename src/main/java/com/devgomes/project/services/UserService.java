package com.devgomes.project.services;

import com.devgomes.project.entities.User;
import com.devgomes.project.repositories.UserRepository;
import com.devgomes.project.services.exceptions.DatabaseException;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser (User user){
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Integrity violation by deleting user {}: {}", id, e.getMessage());
            throw new DatabaseException("Can't delete an user that has pending orders.");
        }
    }

    public User updateUser(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateUserData(entity, user);
        return repository.save(entity);
    }

    private void updateUserData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
