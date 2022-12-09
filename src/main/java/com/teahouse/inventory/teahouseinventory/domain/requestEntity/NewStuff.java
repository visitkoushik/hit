package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import com.teahouse.inventory.teahouseinventory.domain.Employee;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class NewStuff extends Employee {
    
    
    private String userName;
     
    
    private String passWord;
 
     
    private UserType userType;

    public Employee getEmployee(){
        Employee e =new Employee();
        e.setAddress(getAddress());
        e.setDateOfBirth(getDateOfBirth());
        e.setDateOfExit(getDateOfExit());
        e.setDateOfJoin(getDateOfJoin());
        e.setEmail(getEmail());
        e.setFirstName(getFirstName());
        e.setLastName(getLastName());
        e.setMiddleName(getMiddleName());
        e.setFranchises(getFranchises());
        e.setGender(getGender());
        e.setPANNumber(getPANNumber());
        e.setIsCurrent(getIsCurrent());
        e.setMobileNumbers(getMobileNumbers());
        e.setPercentageOfShare(getPercentageOfShare());
        e.setPrimaryAddressIndex(getPrimaryAddressIndex());
        e.setRoles(getRoles());
        
        return e;
    }

}
