package com.devgomes.project.services;

import com.devgomes.project.dto.CategoryDTO;
import com.devgomes.project.entities.Category;
import com.devgomes.project.repository.CategoryRepository;
import com.devgomes.project.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
        return list.stream().map(CategoryDTO::new).toList();
    }

    public CategoryDTO findById(Long id){
       Category entity = repository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException(id));
        return new CategoryDTO(entity);
    }

}
