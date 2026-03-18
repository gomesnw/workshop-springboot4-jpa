package com.devgomes.project.services;

import com.devgomes.project.dto.UserDTO;
import com.devgomes.project.dto.UserInsertDTO;
import com.devgomes.project.dto.UserUpdateDTO;
import com.devgomes.project.entities.User;
import com.devgomes.project.repository.OrderRepository;
import com.devgomes.project.repository.UserRepository;
import com.devgomes.project.services.exceptions.DatabaseException;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final OrderRepository orderRepository;

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
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        if (orderRepository.existsByClientId(id)) {
            throw new DatabaseException("Can't delete an user that has pending orders.");
        }
        repository.delete(entity);
    }

    public UserDTO updateUser(Long id, UserUpdateDTO dto) {
        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateUserData(entity, dto);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    private void updateUserData(User entity, UserUpdateDTO dto) {
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setPhone(dto.phone());
    }
}
