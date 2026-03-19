
package com.devgomes.project.controller;

import com.devgomes.project.dto.ProductDTO;
import com.devgomes.project.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
@Tag(name="Products")
public class ProductController {

    private final ProductService service;

    @GetMapping
    @Operation(summary = "List all products")
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO>  list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a product by ID")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
