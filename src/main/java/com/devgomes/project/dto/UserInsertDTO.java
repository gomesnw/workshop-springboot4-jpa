package com.devgomes.project.dto;

import com.devgomes.project.entities.User;

public record UserInsertDTO(
        String name,
        String email,
        String phone,
        String password
) {
    public User toEntity() {
        return new User(null, name, email, phone, password);
    }

}
