package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Franchises;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.FranchiseRepository;
import com.teahouse.inventory.teahouseinventory.services.FranchisesService;


@Service
public class FrachiseServiceImpl implements FranchisesService{



    private final FranchiseRepository franchiseRepository;

    public FrachiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public List<Franchises> findAll() {
        
        return this.franchiseRepository.findAll();
    }

    @Override
    public Franchises findById(Long Id) {
        
        return this.franchiseRepository.findById(Id).orElseThrow(

            ()-> new ResourceNotFoundException("Franchisee", "ID", Id)
        );
    }

    @Override
    public Franchises save(Franchises t) {
        
        return this.franchiseRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Franchises update(Franchises t, Long id) {
        Franchises f = this.findById(id);
        if(f!=null){
            f.setAddress(t.getAddress());
            f.setIsCurrent(t.getIsCurrent());
            f.setName(t.getName());
            f.setTanNumder(t.getTanNumder());
            f.setOwners(t.getOwners());
        }
        
        return this.franchiseRepository.save(f);
        
    }

    // @Override
    // public List<Franchises> findByOwnerId(String ownerId) {
    
    //     return this.franchiseRepository.findByOwnerId(ownerId);
    // }
    
}
