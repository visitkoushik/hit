package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;


public interface UserLoginRepository extends JpaRepository<UserLogin,Long> {
    @Query("SELECT u FROM userLogin u WHERE u.userName =:userName AND u.passWord=:passWord")
    List<UserLogin> findByCredential(@Param("userName") String userName,@Param("passWord") String passWord); 
}
