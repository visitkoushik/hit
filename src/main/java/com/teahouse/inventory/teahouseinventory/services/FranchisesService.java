package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;


import com.teahouse.inventory.teahouseinventory.domain.Franchises;

public interface FranchisesService extends BaseService<Franchises,Long>{

     List<Franchises> findByOwnerId(String ownerId); 
    
}
