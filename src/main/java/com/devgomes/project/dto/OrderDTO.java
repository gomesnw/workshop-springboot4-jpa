package com.devgomes.project.dto;

import com.devgomes.project.entities.Order;
import com.devgomes.project.entities.enums.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderDTO (
        Long id,
        Instant moment,
        OrderStatus orderStatus,
        UserDTO client,
        List<OrderItemDTO> items,
        Double total
) {

    public OrderDTO(Order entity) {
        this(
                entity.getId(),
                entity.getMoment(),
                entity.getOrderStatus(),
                new UserDTO(entity.getClient()),
                entity.getItems().stream()
                        .map(item -> new OrderItemDTO(
                                item.getId().getProduct().getId(),
                                item.getId().getProduct().getName(),
                                item.getPrice(),
                                item.getQuantity()
                        ))
                        .toList(),
                entity.getTotal()
        );
    }
}
