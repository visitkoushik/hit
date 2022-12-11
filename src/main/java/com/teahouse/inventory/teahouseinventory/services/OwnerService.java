package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

 
import com.teahouse.inventory.teahouseinventory.domain.Owners;

public interface OwnerService extends BaseService<Owners,Long>
{
    
    List<Owners> findAllExOwners();
    List<Owners> findAllOwners();
    List<Owners> findAllByName(String lastName,String firstName);
    List<Owners> findAllOwnersByFranchiseID(Long ID);
    Owners findByUserLogin(Long userLoginID);
}
