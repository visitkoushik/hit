package com.teahouse.inventory.teahouseinventory.domain.baseentities;

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

import com.teahouse.inventory.teahouseinventory.domain.UserLogin;
import com.teahouse.inventory.teahouseinventory.domain.enums.Gender;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

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
    
    @Column(name="role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles;

    @Column(name="dob")
    private Date dateOfBirth;

    @Column(name="addressindex")
    private Short primaryAddressIndex=0;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    private UserLogin userLogin;
}
