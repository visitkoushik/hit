package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.repositories.UserLoginRepository;
import com.teahouse.inventory.teahouseinventory.services.UserLoginService;


@Service
public class UserLoginServiceImpl implements UserLoginService {



    private final UserLoginRepository userLoginRepository;

    public UserLoginServiceImpl(UserLoginRepository userLoginRepository) {
        super();
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    public List<UserLogin> findAll() {
        
        return this.userLoginRepository.findAll();
    }

    @Override
    public UserLogin findById(String Id) {
        
        return null;
    }

    @Override
    public void deleteById(String Id) {
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
    
}
