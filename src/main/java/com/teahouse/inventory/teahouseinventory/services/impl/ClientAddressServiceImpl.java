package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.ClientAddress;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.ClientAddressRepository;
import com.teahouse.inventory.teahouseinventory.services.ClientAddressService;

public class ClientAddressServiceImpl implements ClientAddressService{


    private final ClientAddressRepository clientAddressRepository;
    




    public ClientAddressServiceImpl(ClientAddressRepository clientAddressRepository) {
        this.clientAddressRepository = clientAddressRepository;
    }

    @Override
    public List<ClientAddress> findAll() {
        
        return this.clientAddressRepository.findAll();
    }

    @Override
    public ClientAddress findById(Long Id) {
        // TODO Auto-generated method stub
        return this.clientAddressRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("Client", "ID", Id));

    }

    @Override
    public ClientAddress save(ClientAddress t) {
        // TODO Auto-generated method stub
        return this.clientAddressRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ClientAddress update(ClientAddress t, Long id) {
        ClientAddress c = this.clientAddressRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Client", "ID", t.getId()));
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
        return this.clientAddressRepository.save(c);
    }
    
}
