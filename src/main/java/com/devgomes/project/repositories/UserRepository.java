package com.devgomes.project.repositories;

import com.devgomes.project.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
