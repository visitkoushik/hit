package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@MappedSuperclass
public class PersonEntity extends BaseEntity{
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "mid_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="gender",nullable = false)
    private Gender gender;

    @Column(name = "mobile",unique=true)
    private String mobileNumbers;


    @Column(name="email",unique=true)
    private String email;
    


    @Column(name="dob")
    private Date dateOfBirth;

    @Column(name="addressindex")
    private Short primaryAddressIndex=0;
}
