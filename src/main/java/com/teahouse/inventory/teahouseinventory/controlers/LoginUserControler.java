package com.teahouse.inventory.teahouseinventory.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.GeneralResp;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.LogOut;
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


    @PostMapping("logout")
    public ResponseEntity<GeneralResp>  logout(@RequestBody LogOut logout){
          LoggedInUser loggedId =  this.loggedInUserService.findByAuthKey(logout.getAuthCode());
          if(loggedId!=null){
            loggedId.setLoggedin(false);
            loggedId.setAuthKey(null);
            this.loggedInUserService.update(loggedId, loggedId.getId());
            
            new ResponseEntity<GeneralResp>(new GeneralResp(
            "Logged out successfully",
            HttpStatus.OK.value(),
            null
          ),   HttpStatus.OK);
          }
          
          return new ResponseEntity<GeneralResp>(new GeneralResp(
            "Something went wrong. ",
            HttpStatus.OK.value(),
            null
          ),   HttpStatus.OK);
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
                if(loggedInUser.isLoggedin())
                {
                    lres.setAuthCode(loggedInUser.getAuthKey());
                    lres.setError(null);
                    return new ResponseEntity<LoginResp>(lres,   HttpStatus.ACCEPTED);
    
                }
                else{
                    loggedInUser.setLoggedin(true);
                    LoggedInUser l = this.loggedInUserService.update(loggedInUser, loggedInUser.getId());
                    
                    lres.setAuthCode(l.getAuthKey());
                    lres.setError(null);
                    return new ResponseEntity<LoginResp>(lres,   HttpStatus.ACCEPTED);
               }
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
            userLogin.setIsActive(true);

            UserLogin u = this.userLoginService.save(userLogin);
            return new ResponseEntity<String>("User Created "+u.getUserName(), 
        HttpStatus.CREATED);
    }


    @PostMapping("chagepass")
    public ResponseEntity chagePass(
        @RequestBody String oldPass,
        @RequestBody String newPass
    ){
        return new ResponseEntity<String>("Not yet Implemented", 
        HttpStatus.OK);
    }

}
