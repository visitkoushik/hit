package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
    @Query("SELECT e FROM employee e WHERE e.isCurrent=false")
    List<Employee> findAllExEmployee();

    @Query("SELECT e FROM employee e WHERE e.isCurrent=true")
    List<Employee> findAllEmployee();

    @Query("SELECT e FROM employee e WHERE e.firstName=:firstName AND e.lastName=:lastName")
    List<Employee> findAllByName(String lastName,String firstName);

    @Query("SELECT e FROM employee e WHERE franchise_id=:ID")
    List<Employee> findAllEmployeeByFranchiseID(Long ID);


    @Query("SELECT e FROM employee e WHERE user_login_id =:userLoginID")
    List<Employee> findByUserLogin(Long userLoginID);

}
