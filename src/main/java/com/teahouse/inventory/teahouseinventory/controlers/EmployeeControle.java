package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.services.EmployeeService;
@RestController
@RequestMapping("api/employee/{loginKeyid}")
public class EmployeeControle extends BaseControler<Employee>{



    private final EmployeeService employeeService;


    public EmployeeControle(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity onAdd(Employee t) {
   
        return  new ResponseEntity(this.employeeService.save(t),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Employee t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity onFindById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
