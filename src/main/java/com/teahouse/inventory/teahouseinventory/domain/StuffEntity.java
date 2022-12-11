package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.teahouse.inventory.teahouseinventory.domain.baseentities.PersonEntity;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


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
