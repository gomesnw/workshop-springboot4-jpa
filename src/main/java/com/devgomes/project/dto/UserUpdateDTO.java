package com.devgomes.project.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public record UserUpdateDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        String phone
) implements Serializable { }
