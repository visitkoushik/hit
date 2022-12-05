package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.UserType;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.LoginBody;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.LoginResp;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;

@RestController
@RequestMapping("api/user")
public class LoginUserControler {
    
    private final LoggedInUserService loggedInUserService; 
    private final UserLoginService userLoginService;

    public LoginUserControler(LoggedInUserService loggedInUserService, 
    UserLoginService userLoginService) {
        super();
        this.loggedInUserService = loggedInUserService;
        this.userLoginService = userLoginService;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResp>  login(@RequestBody LoginBody login){
        
       
        LoginResp lres=new LoginResp();
        UserLogin userLogin = this.userLoginService
        .findByCredential(login.getUserid(), login.getPasscode());
        if(userLogin!=null){
            LoggedInUser loggedInUser = this.loggedInUserService
            .findById(userLogin.getLoggedinuser().getId());
           
            if(loggedInUser!=null){
                loggedInUser.setLoggedin(true);
                LoggedInUser l = this.loggedInUserService.update(loggedInUser, loggedInUser.getId());
                
                lres.setAuthCode(l.getAuthKey());
                lres.setError(null);
                return new ResponseEntity<LoginResp>(lres,   HttpStatus.ACCEPTED);
               
            }
             
        }
        lres.setError("Wrong credential. Check your user Name and password");
        return new ResponseEntity<LoginResp>(lres,   HttpStatus.UNAUTHORIZED);
    }
    

    @PostMapping("registerclient")
    public ResponseEntity<String>  Register(@RequestBody UserLogin userLogin){
            LoggedInUser l = 
             this.loggedInUserService.save(new LoggedInUser());
            userLogin.setLoggedinuser(l);
            userLogin.setUserType(UserType.CLIENT);
            userLogin.setIsActive(true);

            UserLogin u = this.userLoginService.save(userLogin);
            return new ResponseEntity<String>("User Created "+u.getUserName(), 
        HttpStatus.CREATED);
    }

}
