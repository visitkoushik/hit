package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import com.teahouse.inventory.teahouseinventory.domain.Address;
import com.teahouse.inventory.teahouseinventory.domain.EmployeeAddress;

import lombok.Data;

@Data
public class EmpAddressResp extends Address{
    
    public EmpAddressResp(EmployeeAddress empAddress){
        this.setArea(empAddress.getArea());
        this.setCity(empAddress.getCity());
        this.setDist(empAddress.getDist());
        this.setHouseNo(empAddress.getHouseNo());
        this.setLocality(empAddress.getLocality());
        this.setPostalCode(empAddress.getPostalCode());
        this.setState(empAddress.getState());
        this.setStreet(empAddress.getStreet());
    }
}
