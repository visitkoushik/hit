package com.teahouse.inventory.teahouseinventory.services;

import com.teahouse.inventory.teahouseinventory.domain.UserLogin;

public interface UserLoginService extends BaseService<UserLogin,Long>{
 
    UserLogin save(UserLogin userLogin);

    UserLogin findByCredential(String userName,String passcode);
   
    
}
