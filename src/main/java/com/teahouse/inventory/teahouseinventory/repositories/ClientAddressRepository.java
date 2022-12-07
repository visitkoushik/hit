package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teahouse.inventory.teahouseinventory.domain.ClientAddress;

public interface ClientAddressRepository extends JpaRepository<ClientAddress,Long>{
    
}
