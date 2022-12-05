package com.teahouse.inventory.teahouseinventory.controlers;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;


@MappedSuperclass
public class BaseControler {

    @Autowired
    private   LoggedInUserService loggedInUserService;

    
    protected boolean validateLoginKey(String loginKey){
        return false;
    }
    
    public Long getUserLoginId(String loginKey){
        LoggedInUser logged=  this.loggedInUserService.findByAuthKey(loginKey);
        if(logged==null || logged.isLoggedin()){
            return null;
        }

        return logged.getUserlogin().getId();
}
}
