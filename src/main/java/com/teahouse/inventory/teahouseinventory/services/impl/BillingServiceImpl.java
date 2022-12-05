package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
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
    public Billing findById(Long Id) {
        return this.billingRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("Billing", "ID", Id));

    }



    @Override
    public Billing save(Billing t) {
         
        return this.billingRepository.save(t);
    }



    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public List<Billing> findByDateRange(Date startDate,Date endDate) {
        
        return this.billingRepository.findByDateRange(startDate, endDate);
    }



    @Override
    public List<Billing> findByEmployee(Long empID) {
   
        return this.billingRepository.findByEmployee(empID);
    }



    @Override
    public Billing update(Billing t, Long id) {
        Billing bill = this.billingRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Billing", "ID", t.getId()));

            bill.setBillingDate(t.getBillingDate());   
            bill.setDiscountAmount(t.getDiscountAmount());   
            bill.setDiscountFormat(t.getDiscountFormat());   
            bill.setEmployee(t.getEmployee());   
            bill.setFranchises(t.getFranchises());   
            bill.setItemEntites(t.getItemEntites());   
        return this.billingRepository.save(bill);
    }

    
    
}
