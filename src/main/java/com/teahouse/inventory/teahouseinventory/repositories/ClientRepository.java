package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teahouse.inventory.teahouseinventory.domain.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
    
}
