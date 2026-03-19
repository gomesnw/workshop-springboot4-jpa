package com.devgomes.project.repository;

import com.devgomes.project.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
     boolean existsByClientId(Long id);
}

