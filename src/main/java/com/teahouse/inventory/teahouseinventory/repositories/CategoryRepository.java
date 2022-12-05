package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM category c WHERE c.available=:active")
    List<Category> findByStatus(Boolean active);
}
