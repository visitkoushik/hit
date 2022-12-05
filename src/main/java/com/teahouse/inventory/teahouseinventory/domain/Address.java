package com.teahouse.inventory.teahouseinventory.domain;

 

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
@Entity(name="address")
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
