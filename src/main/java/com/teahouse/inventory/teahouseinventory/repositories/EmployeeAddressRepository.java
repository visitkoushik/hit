package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.teahouse.inventory.teahouseinventory.domain.EmployeeAddress;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,Long>{
    
}
