package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Category;

public interface CategoryService extends BaseService<Category,Long>{
    
    List<Category> findByStatus(Boolean active);
    
    
}
