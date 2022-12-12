package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teahouse.inventory.teahouseinventory.domain.Client; 

public interface ClientRepository extends JpaRepository<Client,Long>{
    
    @Query("SELECT c FROM client c WHERE c.mobileNumbers=:mobileNumber")
    Optional<Client> findByContact(String mobileNumber);
}
