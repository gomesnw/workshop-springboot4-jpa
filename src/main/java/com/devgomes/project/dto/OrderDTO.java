package com.devgomes.project.dto;

import com.devgomes.project.entities.Order;
import com.devgomes.project.entities.enums.OrderStatus;

import java.time.Instant;

public record OrderDTO (
        Long id,
        Instant moment,
        OrderStatus orderStatus,
        Long clientId,
        String clientName,
        Double total
) {

    public OrderDTO(Order entity) {
        this(
                entity.getId(),
                entity.getMoment(),
                entity.getOrderStatus(),
                entity.getClient().getId(),
                entity.getClient().getName(),
                entity.getTotal()
        );
    }
}
