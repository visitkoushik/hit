package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

 
import com.teahouse.inventory.teahouseinventory.domain.baseentities.PersonEntity;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender; 

import lombok.Data;


@Data
public class ProfileResp {

    private String firstName;

    private String middleName;

     private String lastName;

    private Gender gender;

     private String mobileNumbers;


    private String email;
 
    private String userName; 
    

     

    public ProfileResp(PersonEntity profile){
        this.firstName =  profile.getFirstName();
        this.middleName = profile.getMiddleName();
        this.lastName = profile.getLastName();
        this.email = profile.getEmail();
        this.gender = profile.getGender();
        this.mobileNumbers = profile.getMobileNumbers();
        this.userName = profile.getUserLogin().getUserName(); 
    }

    // public ProfileResp(Employee profile){
    //    this.firstName =  profile.getFirstName();
    //    this.middleName = profile.getMiddleName();
    //    this.lastName = profile.getLastName();
    //    this.email = profile.getEmail();
    //    this.gender = profile.getGender();
    //    this.mobileNumbers = profile.getMobileNumbers();
    //    this.userLogin = profile.getUserLogin();
    // }
    
}
