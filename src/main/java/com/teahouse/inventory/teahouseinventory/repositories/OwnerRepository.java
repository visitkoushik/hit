package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Owners;

@Repository
public interface OwnerRepository extends JpaRepository<Owners,Long>{
    @Query("SELECT e FROM owners e WHERE e.isCurrent=false")
    List<Owners> findAllExOwners();

    @Query("SELECT e FROM owners e WHERE e.isCurrent=true")
    List<Owners> findAllOwners();

    @Query("SELECT e FROM owners e WHERE e.firstName=:firstName AND e.lastName=:lastName")
    List<Owners> findAllByName(String lastName,String firstName);

    @Query("SELECT e FROM owners e WHERE franchise_id=:ID")
    List<Owners> findAllOwnersByFranchiseID(Long ID);


    @Query("SELECT e FROM owners e WHERE user_login_id =:userLoginID")
    List<Owners> findByUserLogin(Long userLoginID);
}
