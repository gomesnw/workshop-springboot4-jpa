package com.devgomes.project.dto;

import com.devgomes.project.entities.Category;
import com.devgomes.project.entities.Product;

import java.util.List;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl,
        List<String> categories
) {

    public ProductDTO(Product entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getCategories().stream().map(Category::getName).toList()
        );
    }
}
