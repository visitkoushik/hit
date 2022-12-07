package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import com.teahouse.inventory.teahouseinventory.domain.Address;
import com.teahouse.inventory.teahouseinventory.domain.ClientAddress;

public class ClientAddressResp extends Address{
    
    public ClientAddressResp(ClientAddress clientAddress){
        this.setArea(clientAddress.getArea());
        this.setCity(clientAddress.getCity());
        this.setDist(clientAddress.getDist());
        this.setHouseNo(clientAddress.getHouseNo());
        this.setLocality(clientAddress.getLocality());
        this.setPostalCode(clientAddress.getPostalCode());
        this.setState(clientAddress.getState());
        this.setStreet(clientAddress.getStreet());
    }
}