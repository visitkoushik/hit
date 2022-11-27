package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Employee;

public interface EmployeeService extends BaseService<Employee,String>
{
    
    List<Employee> findAllExEmployee();
    List<Employee> findAllByName(String lastName,String firstName);
}
