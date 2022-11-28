package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.ItemPricing;
import com.teahouse.inventory.teahouseinventory.repositories.ItemPriceRepository;
import com.teahouse.inventory.teahouseinventory.services.ItemPricingService;

@Service
public class ItemPriceServiceImpl implements ItemPricingService {



    private final ItemPriceRepository itemPriceRepository;

    


    public ItemPriceServiceImpl(ItemPriceRepository itemPriceRepository) {
        this.itemPriceRepository = itemPriceRepository;
    }

    @Override
    public List<ItemPricing> findAll() {
        
        return this.itemPriceRepository.findAll();
    }

    @Override
    public ItemPricing findById(String Id) {
        return this.itemPriceRepository.findById(Id).orElse(null);
    }

    @Override
    public ItemPricing save(ItemPricing t) {
        return this.itemPriceRepository.save(t);
    }

    @Override
    public void deleteById(String Id) {
        // TODO Auto-generated method stub
        
    }
    
}
