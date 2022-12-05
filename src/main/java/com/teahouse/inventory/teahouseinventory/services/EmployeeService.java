package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Employee;

public interface EmployeeService extends BaseService<Employee,Long>
{
    
    List<Employee> findAllExEmployee();
    List<Employee> findAllEmployee();
    List<Employee> findAllByName(String lastName,String firstName);
    List<Employee> findAllEmployeeByFranchiseID(Long ID);
}
