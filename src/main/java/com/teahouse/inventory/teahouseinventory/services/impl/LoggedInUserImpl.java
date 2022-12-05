package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List; 
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.LoggedInUserRepository;
import com.teahouse.inventory.teahouseinventory.services.LoggedInUserService;

@Service
public class LoggedInUserImpl implements LoggedInUserService {


    private final LoggedInUserRepository loggedInUserRepository;


    public LoggedInUserImpl(LoggedInUserRepository loggedInUserRepository) {
        this.loggedInUserRepository = loggedInUserRepository;
    }

    @Override
    public List<LoggedInUser> findAll() {
        
        return null;
    }

    @Override
    public LoggedInUser findById(Long Id) {
      return this.loggedInUserRepository.findById(Id).orElse(null);
    }

    @Override
    public LoggedInUser save(LoggedInUser t) {
        
        return this.loggedInUserRepository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LoggedInUser update(LoggedInUser t, Long id) {
        LoggedInUser loggedin = this.loggedInUserRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Loggin", "ID", t.getId()));
 
            String authkey="";
            
            if(t.isLoggedin()){
                authkey = generateKey(loggedin.getUserlogin().getId()+""+loggedin.getId());
            }
                
            loggedin.setAuthKey(authkey);
          
            loggedin.setLoggedin(t.isLoggedin());  
        return this.loggedInUserRepository.save(loggedin);
    }
    




    private String generateKey(String loginId){
        
        UUID uuid = UUID.nameUUIDFromBytes((System.nanoTime()+UUID.randomUUID().toString() +"-"+loginId).getBytes());
        UUID uuid2 = UUID.nameUUIDFromBytes((uuid.toString() +UUID.randomUUID().toString() +"-"+loginId).getBytes());

        return uuid2.toString()+"-"+uuid.toString();
    }

    @Override
    public LoggedInUser findByAuthKey(String loginKey) {
      
        return this.loggedInUserRepository.findByAuthKey(loginKey).orElse(null);
    }



}
