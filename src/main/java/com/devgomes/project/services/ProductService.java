package com.devgomes.project.services;

import com.devgomes.project.dto.ProductDTO;
import com.devgomes.project.entities.Product;
import com.devgomes.project.repository.ProductRepository;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public List<ProductDTO> findAll(){
        List<Product> list = repository.findAll();
        return list.stream().map(ProductDTO::new).toList();
    }

    public ProductDTO findById(Long id){
        Product entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new ProductDTO(entity);
    }

}
