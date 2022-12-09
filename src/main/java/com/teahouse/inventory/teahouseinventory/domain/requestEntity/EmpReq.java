package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.sql.Date;

import com.teahouse.inventory.teahouseinventory.domain.Franchises;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

public class EmpReq {
  
    private Boolean isCurrent;

 
    private String PANNumber;


 
    private Date dateOfBirth;

  
  
    private Date dateOfJoin;
 
    private Date dateOfExit;


 
    private Roles roles;

  
    private float percentageOfShare;

 
    private Franchises franchises;


    
    private UserLogin userLogin;


    private String firstName;


    private String middleName;


    private String lastName;


    private Gender gender;


    private String mobileNumbers;



    private String email;
    


    private Short primaryAddressIndex=0;
}
