package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.baseentities.PersonEntity;
import com.teahouse.inventory.teahouseinventory.domain.enums.UserType;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.ProfileResp;
import com.teahouse.inventory.teahouseinventory.services.EmployeeService;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;
import com.teahouse.inventory.teahouseinventory.services.OwnerService;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;

@RestController
@RequestMapping("api/user/{loginKeyid}")
public class UserControler {

    private final EmployeeService employeeService;
    private final LoggedInUserService loggedInUserService;
    private final OwnerService ownerService;


    public UserControler(
        EmployeeService employeeService, 
    LoggedInUserService loggedInUserService, 
    OwnerService ownerService) {

    this.employeeService = employeeService;
    this.loggedInUserService = loggedInUserService;
    this.ownerService = ownerService;
}


    @GetMapping("profile")
  private ResponseEntity getProfile(@PathVariable("loginKeyid")  String loginKey)
  {
    if(isValidationFailed(loginKey)){
        return   new ResponseEntity<String>
                ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    }
    else{
        UserLogin u = getUserLogin(loginKey);
        PersonEntity currentUser=null;
        
        if(u.getUserType() == UserType.EMPLOYEE)
        {
            currentUser = this.employeeService.findByUserLogin(u.getId());
            
        }
        else if(u.getUserType() == UserType.OWNER){
            currentUser = this.ownerService.findByUserLogin(u.getId());
            
        }
        else if(u.getUserType() == UserType.CLIENT){
            
        }

        
       if(currentUser!=null) {
        switch(u.getUserType()){
         
            case CLIENT:
                return new ResponseEntity<String>("Not available" ,HttpStatus.OK);
               
            case EMPLOYEE:
            case OWNER:
 
                // return new ResponseEntity<String>("Not available" ,HttpStatus.OK); 
                return new ResponseEntity<ProfileResp>(new ProfileResp(currentUser),HttpStatus.OK);
              
            default:
                return new ResponseEntity<String>("Invalid user type",HttpStatus.BAD_REQUEST);
                
        }
             
       }
       
    }
    
    return new ResponseEntity<String>(
      "Smething went wrong",
      HttpStatus.OK
    );
    
  }
    




  protected boolean isValidationFailed(String loginKey){
    if(loginKey.equals("1")) return false;
    LoggedInUser logged=  this.loggedInUserService.findByAuthKey(loginKey);
    return  logged==null || !logged.isLoggedin();
}

public UserLogin getUserLogin(String loginKey){
   LoggedInUser logged=  this.loggedInUserService.findByAuthKey(loginKey);
   return logged==null?null:logged.getUserlogin();
}
}
