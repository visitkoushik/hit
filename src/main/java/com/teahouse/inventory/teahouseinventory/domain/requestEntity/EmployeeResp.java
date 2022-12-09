package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.domain.Franchises;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

import lombok.Data;


@Data
public class EmployeeResp {
   
 
   
  private String firstName;

 
  private String middleName;

 
  private String lastName;

  
  private Gender gender;

 


    public EmployeeResp(Employee employee){
    
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.middleName = employee.getMiddleName();
        this.gender = employee.getGender();
         


    }


}
