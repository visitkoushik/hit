package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.repositories.BillingItemRepository;
import com.teahouse.inventory.teahouseinventory.services.BillingItemService;

@Service
public class BillingItemServiceImpl implements BillingItemService {


    private final BillingItemRepository billiItemRepository;
    

    public BillingItemServiceImpl(BillingItemRepository billiItemRepository) {
        this.billiItemRepository = billiItemRepository;
    }

    @Override
    public List<BillingItem> findAll() {
        // TODO Auto-generated method stub
        return this.billiItemRepository.findAll();
    }

    @Override
    public BillingItem findById(Long Id) {
        // TODO Auto-generated method stub
        return billiItemRepository.findById(Id).orElse(null);
    }

    @Override
    public BillingItem save(BillingItem t) {
        // TODO Auto-generated method stub
        return billiItemRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BillingItem update(BillingItem t, Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
