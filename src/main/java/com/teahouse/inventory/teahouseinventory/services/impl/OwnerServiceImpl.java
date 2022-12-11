package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Owners;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.OwnerRepository;
import com.teahouse.inventory.teahouseinventory.services.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    

    @Override
    public List<Owners> findAll() {
        
        return this.ownerRepository.findAll();
    }

    @Override
    public Owners findById(Long Id) {
        
        return this.ownerRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("Ownerse", "ID", Id));

    }

    @Override
    public Owners save(Owners t) {
        return this.ownerRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Owners> findAllExOwners() {
        
        return this.ownerRepository.findAllExOwners();
    }

    @Override
    public List<Owners> findAllByName(String lastName, String firstName) {
        return this.ownerRepository.findAllByName(lastName, firstName);
    }

    @Override
    public List<Owners> findAllOwnersByFranchiseID(Long ID) {
        
        return this.ownerRepository.findAllOwnersByFranchiseID(ID);
    }

    @Override
    public List<Owners> findAllOwners() {
        
        return this.ownerRepository.findAllOwners();
    }


    @Override
    public Owners update(Owners t, Long id) {
        Owners emp = this.ownerRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Ownerse", "ID", t.getId()));

            // emp.setAddress(emp.getAddress()); 
            emp.setEmail(t.getEmail());   
            emp.setFirstName(t.getFirstName());   
            emp.setGender(t.getGender());   
            emp.setLastName(t.getLastName());   
            emp.setMiddleName(t.getMiddleName());   
            emp.setMobileNumbers(t.getMobileNumbers());   
            emp.setRoles(t.getRoles());   
            emp.setPrimaryAddressIndex(t.getPrimaryAddressIndex());   
            emp.setDateOfExit(t.getDateOfExit());
            emp.setDateOfJoin(t.getDateOfJoin()); 
            emp.setFranchises(t.getFranchises());
            emp.setPercentageOfShare(t.getPercentageOfShare());
            emp.setIsCurrent(t.getIsCurrent());
            emp.setDateOfBirth(t.getDateOfBirth());
            emp.setPANNumber(t.getPANNumber());
        return this.ownerRepository.save(emp);
    }


    @Override
    public Owners findByUserLogin(Long userLoginID) {
       
        List<Owners> empList = this.ownerRepository.findByUserLogin(userLoginID);

        if(empList==null || empList.size()==0){
            return  null;
        }

        return empList.get(0);
    }

 
}
