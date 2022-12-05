package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.ItemPricing;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
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
    public ItemPricing findById(Long Id) {
        return this.itemPriceRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("ItemPricing", "ID",  Id ));
    }

    @Override
    public ItemPricing save(ItemPricing t) {
        return this.itemPriceRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ItemPricing update(ItemPricing t, Long id) {
        ItemPricing itmp = this.itemPriceRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("ItemPricing", "ID", t.getId()));
 
            itmp.setPurchaseAmount(t.getPurchaseAmount());   
            itmp.setSellingAmount(t.getSellingAmount());   
            itmp.setUpdateDate(t.getUpdateDate());  
        return this.itemPriceRepository.save(itmp);
    }
    
}
