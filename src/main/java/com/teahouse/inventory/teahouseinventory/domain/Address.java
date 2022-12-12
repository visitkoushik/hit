package com.teahouse.inventory.teahouseinventory.domain;

 

import javax.persistence.MappedSuperclass;
import com.teahouse.inventory.teahouseinventory.domain.baseentities.BaseEntity;
import lombok.Data;
@Data
 
@MappedSuperclass
public class Address extends BaseEntity {

    
    private String houseNo;
    private String street;
    private String locality;
    private String area;
    private String city;
    private String dist;
    private String state;
    private String postalCode;



}
