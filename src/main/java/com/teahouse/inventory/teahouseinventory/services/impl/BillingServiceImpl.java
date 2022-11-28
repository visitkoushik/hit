package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.repositories.BillingRepository;
import com.teahouse.inventory.teahouseinventory.services.BillingService;


@Service
public class BillingServiceImpl implements BillingService{


    private final BillingRepository billingRepository;



    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }



    @Override
    public List<Billing> findAll() {
       
        return this.billingRepository.findAll();
    }



    @Override
    public Billing findById(String Id) {
        return this.billingRepository.findById(Id).orElse(null);
    }



    @Override
    public Billing save(Billing t) {
         
        return this.billingRepository.save(t);
    }



    @Override
    public void deleteById(String Id) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public List<Billing> findByDateRange(Date startDate,Date endDate) {
        
        return this.billingRepository.findByDateRange(startDate, endDate);
    }



    @Override
    public List<Billing> findByEmployee(String empID) {
   
        return this.billingRepository.findByEmployee(empID);
    }

    
    
}
