package com.devgomes.project.repository;

import com.devgomes.project.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public boolean existsByClientId(Long id);
}

