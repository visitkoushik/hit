package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
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
    public Employee findById(Long Id) {
        
        return this.employeeRepository.findById(Id).orElseThrow(
            ()-> new ResourceNotFoundException("Employeee", "ID", Id));

    }

    @Override
    public Employee save(Employee t) {
        return this.employeeRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
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
    public List<Employee> findAllEmployeeByFranchiseID(Long ID) {
        
        return this.employeeRepository.findAllEmployeeByFranchiseID(ID);
    }

    @Override
    public List<Employee> findAllEmployee() {
        
        return this.employeeRepository.findAllEmployee();
    }


    @Override
    public Employee update(Employee t, Long id) {
        Employee emp = this.employeeRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Employeee", "ID", t.getId()));

            // emp.setAddress(emp.getAddress()); 
            emp.setEmail(t.getEmail());   
            emp.setFirstName(t.getFirstName());   
            emp.setGender(t.getGender());   
            emp.setLastName(t.getLastName());   
            emp.setMiddleName(t.getMiddleName());   
            emp.setMobileNumbers(t.getMobileNumbers());   
            emp.setRoles(t.getRoles());   
            emp.setPrimaryAddressIndex(t.getPrimaryAddressIndex());   
            emp.setDateOfExit(t.getDateOfExit());
            emp.setDateOfJoin(t.getDateOfJoin()); 
            emp.setFranchises(t.getFranchises());
            emp.setIsCurrent(t.getIsCurrent());
            emp.setDateOfBirth(t.getDateOfBirth());
            emp.setPANNumber(t.getPANNumber());
        return this.employeeRepository.save(emp);
    }


    @Override
    public Employee findByUserLogin(Long userLoginID) {
       
        List<Employee> empList = this.employeeRepository.findByUserLogin(userLoginID);

        if(empList==null || empList.size()==0){
            return  null;
        }

        return empList.get(0);
    }
    
}
