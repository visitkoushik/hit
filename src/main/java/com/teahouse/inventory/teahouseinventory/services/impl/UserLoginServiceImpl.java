package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List; 

import org.springframework.stereotype.Service;
 
import com.teahouse.inventory.teahouseinventory.domain.UserLogin; 
import com.teahouse.inventory.teahouseinventory.repositories.UserLoginRepository;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;


@Service
public class UserLoginServiceImpl implements UserLoginService {



    private final UserLoginRepository userLoginRepository;
    private final LoggedInUserService loggedInUserService;

    public UserLoginServiceImpl(UserLoginRepository userLoginRepository,
    LoggedInUserService loggedInUserService) {
                super();
        this.userLoginRepository = userLoginRepository;
        this.loggedInUserService = loggedInUserService;
    }

    

    @Override
    public List<UserLogin> findAll() {
        
        return this.userLoginRepository.findAll();
    }

    @Override
    public UserLogin findById(Long Id) {
        
        return null;
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserLogin save(UserLogin userLogin) {
         
        return this.userLoginRepository.save(userLogin);
    }

    @Override
    public UserLogin findByCredential(String userName, String passCode) {
        List<UserLogin> u = this.userLoginRepository.findByCredential(userName, passCode);
        return u.isEmpty()?null:u.get(0);

    }

    @Override
    public UserLogin update(UserLogin t, Long id) {
 
 
            // String authkey="";
            
            // if(t.isLoggedin()){
            //     authkey = generateKey(login.getUserId()+""+login.getId());
            // }
                
            // login.setAuthKey(authkey);
          
            // login.setLoggedin(t.isLoggedin());  
        return null;
    }



    
}
