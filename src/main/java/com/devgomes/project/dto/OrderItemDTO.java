package com.devgomes.project.dto;

public record OrderItemDTO(
        Long productId,
        String productName,
        Double price,
        Integer quantity
) {
}
