package com.devgomes.project.controller;

import com.devgomes.project.dto.CategoryDTO;
import com.devgomes.project.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categories")
@Tag(name="Categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    @Operation(summary = "List all categories")
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO>  list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a category by ID")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
