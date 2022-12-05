package com.teahouse.inventory.teahouseinventory.services;

 

import com.teahouse.inventory.teahouseinventory.domain.LoggedInUser;

public interface LoggedInUserService  extends BaseService<LoggedInUser,Long>{
    



    LoggedInUser findByAuthKey(String loginKey);



}
