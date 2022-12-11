package com.teahouse.inventory.teahouseinventory.domain.requestEntity;



import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;

import lombok.Data;


@Data
public class EmployeeResp {
   
 
   
  private String firstName;

 
  private String middleName;

 
  private String lastName;

  
  private Gender gender;


  private Long id;

 


    public EmployeeResp(Employee employee){
    
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.middleName = employee.getMiddleName();
        this.gender = employee.getGender();
        this.id=employee.getId() ;


    }


}
