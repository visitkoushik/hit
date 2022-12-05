package com.teahouse.inventory.teahouseinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teahouse.inventory.teahouseinventory.domain.ItemPricing;

public interface ItemPriceRepository extends JpaRepository<ItemPricing,Long> {
    
}
