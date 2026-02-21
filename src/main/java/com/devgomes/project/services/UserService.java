package com.devgomes.project.services;

import com.devgomes.project.dto.UserDTO;
import com.devgomes.project.dto.UserInsertDTO;
import com.devgomes.project.dto.UserUpdateDTO;
import com.devgomes.project.entities.User;
import com.devgomes.project.repositories.UserRepository;
import com.devgomes.project.services.exceptions.DatabaseException;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserDTO::new).toList();
    }
    public UserDTO findById(Long id) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserDTO(entity);
    }

    public UserDTO insertUser (UserInsertDTO dto) {
        User entity = dto.toEntity();
        entity = repository.save(entity);
        return new UserDTO(entity);
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

    public UserDTO updateUser(Long id, UserUpdateDTO dto) {
        try {
            User entity = repository.getReferenceById(id);
            updateUserData(entity, dto);
            entity = repository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateUserData(User entity, UserUpdateDTO dto) {
        entity.setName(dto.name());
        entity.setPhone(dto.phone());
    }
}
