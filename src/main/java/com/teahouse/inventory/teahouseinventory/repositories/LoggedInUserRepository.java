package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;

@Repository
public interface LoggedInUserRepository extends JpaRepository<LoggedInUser,Long>{
    

    @Query("SELECT l FROM logged_user l WHERE l.authKey=:loginKey")
    Optional<LoggedInUser> findByAuthKey(String loginKey);

}
