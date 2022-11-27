package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Owner;
import com.teahouse.inventory.teahouseinventory.repositories.OwnerRepository;
import com.teahouse.inventory.teahouseinventory.services.OwnerService;


@Service
public class OwnerServiceImpl implements OwnerService {


    private final OwnerRepository ownerRepository;


    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findAll() {
        
        return this.ownerRepository.findAll();
    }

    @Override
    public Owner findById(String Id) {
        
        return this.ownerRepository.findById(Id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
         
        return this.ownerRepository.save(owner);
    }

    @Override
    public void deleteById(String Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Owner> findAllSuperOwner() {
        
        return this.ownerRepository.findAllSuperOwner();
    }

    @Override
    public List<Owner> findAllOwner() {
        return this.ownerRepository.findAllOwner();
    }

    @Override
    public List<Owner> findAllExOwner() {
        return this.ownerRepository.findAllExOwner();
    }
    
}
