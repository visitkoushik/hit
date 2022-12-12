package com.teahouse.inventory.teahouseinventory.domain.baseentities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.teahouse.inventory.teahouseinventory.domain.EmployeeAddress;

import lombok.Data;

@Data
@MappedSuperclass
public class StuffEntity extends PersonEntity{
    @Column(name="status",nullable = false)
    private Boolean isCurrent;

    @Column(name="pan_number",unique=true )
    private String PANNumber;


    @Column(name="dob" ,nullable = false)
    private Date dateOfBirth;
  
    @Column(name="doj",nullable = false)
    private Date dateOfJoin;

    @Column(name="doe")
    private Date dateOfExit;

    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeAddress address;

}
