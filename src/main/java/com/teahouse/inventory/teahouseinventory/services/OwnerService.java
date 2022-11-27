package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Owner;

public interface OwnerService extends BaseService<Owner,String>{

    List<Owner> findAllSuperOwner();
    List<Owner> findAllFranchiseOwner(); 
    List<Owner> findAllExOwner();
}
