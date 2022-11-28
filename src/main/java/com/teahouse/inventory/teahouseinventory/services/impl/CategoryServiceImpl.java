package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Category;
import com.teahouse.inventory.teahouseinventory.repositories.CategoryRepository;
import com.teahouse.inventory.teahouseinventory.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{


    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(String Id) {
         
        return this.categoryRepository.findById(Id).orElse(null);
    }

    @Override
    public Category save(Category t) {
        
        return this.categoryRepository.save(t);
    }

    @Override
    public void deleteById(String Id) {
        // TODO Auto-generated method stub
        
    }
    
}
