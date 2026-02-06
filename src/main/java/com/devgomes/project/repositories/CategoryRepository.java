package com.devgomes.project.repositories;

import com.devgomes.project.entities.Category;
import com.devgomes.project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

