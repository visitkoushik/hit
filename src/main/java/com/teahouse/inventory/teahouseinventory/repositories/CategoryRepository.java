package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teahouse.inventory.teahouseinventory.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,String> {
    
}
