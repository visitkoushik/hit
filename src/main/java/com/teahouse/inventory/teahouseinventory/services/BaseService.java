package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

public interface BaseService<T,ID> {
    List<T> findAll();
    T findById(ID Id);
    T save(T t);
    void deleteById(ID Id);
    
}
