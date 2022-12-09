package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import com.teahouse.inventory.teahouseinventory.domain.Address;
import com.teahouse.inventory.teahouseinventory.domain.EmployeeAddress;

import lombok.Data;

@Data
public class EmpAddressResp {
    private String houseNo="";
    private String street="";
    private String locality="";
    private String area="";
    private String city="";
    private String dist="";
    private String state="";
    private String postalCode="";
    public EmpAddressResp(Address address){
        this.setArea(address.getArea()!=null?address.getArea():"");
        this.setCity(address.getCity()!=null?address.getCity():"");
        this.setDist(address.getDist()!=null?address.getDist():"");
        this.setHouseNo(address.getHouseNo()!=null?address.getHouseNo():"");
        this.setLocality(address.getLocality()!=null?address.getLocality():"");
        this.setPostalCode(address.getPostalCode()!=null?address.getPostalCode():"");
        this.setState(address.getState()!=null?address.getState():"");
        this.setStreet(address.getStreet()!=null?address.getStreet():"");
    }
}
