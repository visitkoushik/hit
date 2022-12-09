package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Franchises;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchises,Long>{
    
 
    

}
