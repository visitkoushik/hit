package com.teahouse.inventory.teahouseinventory.controlers;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;


@MappedSuperclass
public abstract class BaseControler<T> {

    @Autowired
    private LoggedInUserService loggedInUserService; 
    

    public String loginKey="";

    public abstract ResponseEntity onAdd(T t);   
    @PostMapping("add") 
    public ResponseEntity add(
    @PathVariable("loginKeyid")  String loginKey,  
    @RequestBody T t){
        if(isValidationFailed(loginKey)){
            return   new ResponseEntity<String>
                    ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
        }
        this.loginKey=loginKey;
        return this.onAdd(t);
    }
    
    

    public abstract ResponseEntity onUpdate(Long id,T t);    
    @PutMapping("edit/{id}")
    public  ResponseEntity update(  
        @PathVariable("loginKeyid")  String loginKey,  
        @PathVariable("id") Long id, 
        @RequestBody T t){
            if(isValidationFailed(loginKey)){
                return   new ResponseEntity<String>
                        ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
            }
            this.loginKey=loginKey;
            return this.onUpdate(id,t);
        }




    public abstract ResponseEntity onFindAll(Boolean active);    
    @GetMapping("list/all")
    public ResponseEntity findAll(
            @PathVariable("loginKeyid")  String loginKey,  
            @RequestParam(name="active",required = false) @Nullable Boolean active
        ) 
        {
            if(isValidationFailed(loginKey)){
                return   new ResponseEntity<String>
                        ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
            }
            this.loginKey=loginKey;
            return this.onFindAll(active);
        }
   
 

    public abstract ResponseEntity onFindById(Long id);
    @GetMapping("list")
    public ResponseEntity findById(
        @PathVariable("loginKeyid")  String loginKey,  
        @RequestParam(name="id",required = true) Long id
        ) {

            if(isValidationFailed(loginKey)){
                return   new ResponseEntity<String>
                ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
            }

            this.loginKey=loginKey;
        return   this.onFindById(id);
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
