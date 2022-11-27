package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.repositories.EmployeeRepository;
import com.teahouse.inventory.teahouseinventory.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    

    @Override
    public List<Employee> findAll() {
        
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(String Id) {
        
        return this.employeeRepository.findById(Id).orElse(null);
    }

    @Override
    public Employee save(Employee t) {
        return this.employeeRepository.save(t);
    }

    @Override
    public void deleteById(String Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Employee> findAllExEmployee() {
        
        return this.employeeRepository.findAllExEmployee();
    }

    @Override
    public List<Employee> findAllByName(String lastName, String firstName) {
        return this.employeeRepository.findAllByName(lastName, firstName);
    }

    @Override
    public List<Employee> findAllEmployeeByFranchiseID(String ID) {
        
        return this.employeeRepository.findAllEmployeeByFranchiseID(ID);
    }

    @Override
    public List<Employee> findAllEmployee() {
        
        return this.employeeRepository.findAllEmployee();
    }
    
}
