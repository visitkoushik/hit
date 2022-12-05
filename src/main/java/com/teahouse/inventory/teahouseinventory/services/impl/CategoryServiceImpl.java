package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Category;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
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
    public Category findById(Long Id) {
         
        return this.categoryRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("Category", "ID", Id));

    }

    @Override
    public Category save(Category t) {
        
        return this.categoryRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Category update(Category t, Long id) {
        Category cat = this.categoryRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Category", "ID", t.getId()));

            System.out.println(t.toString());
        cat.setCategoryName(t.getCategoryName());   
        cat.setAvailable(t.isAvailable());   

        return this.categoryRepository.save(cat);
    }

    @Override
    public List<Category> findByStatus(Boolean active) {
        
        return this.categoryRepository.findByStatus(active);
    }
    
}
