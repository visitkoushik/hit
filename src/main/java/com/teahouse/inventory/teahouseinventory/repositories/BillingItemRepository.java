package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teahouse.inventory.teahouseinventory.domain.BillingItem;

public interface BillingItemRepository extends JpaRepository<BillingItem,Long>{
    
}
