package com.teahouse.inventory.teahouseinventory.services;

import java.util.Optional;

import org.springframework.lang.Nullable;

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;

public interface LoggedInUserService  extends BaseService<LoggedInUser,Long>{
    



    LoggedInUser findByAuthKey(String loginKey);



}
