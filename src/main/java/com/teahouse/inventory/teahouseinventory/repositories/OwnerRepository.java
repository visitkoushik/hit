package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {
    @Query("SELECT o FROM owner o WHERE o.roles='SUPERADMIN' AND o.isCurrent=true")
    List<Owner> findAllSuperOwner();
    @Query("SELECT o FROM owner o WHERE o.isCurrent=true")
    List<Owner> findAllOwner(); 
    @Query("SELECT o FROM owner o WHERE o.isCurrent=false")
    List<Owner> findAllExOwner();
}
