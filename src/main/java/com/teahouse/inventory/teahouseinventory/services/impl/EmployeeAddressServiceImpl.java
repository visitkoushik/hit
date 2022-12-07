package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

 
import com.teahouse.inventory.teahouseinventory.domain.EmployeeAddress;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.EmployeeAddressRepository;
import com.teahouse.inventory.teahouseinventory.services.EmployeeAddressService;

public class EmployeeAddressServiceImpl implements EmployeeAddressService {


    private final EmployeeAddressRepository empAddressRepository;

    public EmployeeAddressServiceImpl(EmployeeAddressRepository empAddressRepository) {
        this.empAddressRepository = empAddressRepository;
    }

    @Override
    public List<EmployeeAddress> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmployeeAddress findById(Long Id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress t) {
        // TODO Auto-generated method stub
        return this.empAddressRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EmployeeAddress update(EmployeeAddress t, Long id) {
        EmployeeAddress c = this.empAddressRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("EmployeeAddress", "ID", t.getId()));
        if(c!=null){
            c.setArea(t.getArea());
            c.setCity(t.getCity());
            c.setDist(t.getDist()); 
            c.setHouseNo(t.getHouseNo());
            c.setLocality(t.getLocality());
            c.setPostalCode(t.getLocality());
            c.setState(t.getState());
            c.setStreet(t.getStreet());
            
        }
        return this.empAddressRepository.save(c);
    }
    
}
