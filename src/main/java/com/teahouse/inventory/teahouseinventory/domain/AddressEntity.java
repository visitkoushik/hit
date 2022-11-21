package com.teahouse.inventory.teahouseinventory.domain;

 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
@Entity
public class AddressEntity extends BaseEntity {

    private String houseNo;
    private String street;
    private String locality;
    private String area;
    private String city;
    private String dist;
    private String state;
    private String postalCode;
    


}
