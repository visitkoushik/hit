package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teahouse.inventory.teahouseinventory.domain.Item;

public interface ItemRepository  extends JpaRepository<Item,Long>{
    
    @Query("SELECT i FROM item i WHERE i.available=:active")
    List<Item> findByStatus(Boolean active);
}
