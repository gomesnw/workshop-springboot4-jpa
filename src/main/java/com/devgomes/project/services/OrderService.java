package com.devgomes.project.services;

import com.devgomes.project.dto.OrderDTO;
import com.devgomes.project.entities.Order;
import com.devgomes.project.repositories.OrderRepository;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;

    public List<OrderDTO> findAll() {
        List<Order> list = repository.findAll();
        return list.stream().map(OrderDTO::new).toList();
    }

    public OrderDTO findById(Long id) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new OrderDTO(entity);
    }

}
