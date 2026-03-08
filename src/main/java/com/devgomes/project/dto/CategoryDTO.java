package com.devgomes.project.dto;

import com.devgomes.project.entities.Category;
import com.devgomes.project.entities.Product;

import java.util.List;

public record CategoryDTO(
        Long id,
        String name,
        List<String> products
) {
    public CategoryDTO(Category entity){
        this(
                entity.getId(),
                entity.getName(),
                entity.getProducts().stream().map(Product::getName).toList()
        );
    }
}
