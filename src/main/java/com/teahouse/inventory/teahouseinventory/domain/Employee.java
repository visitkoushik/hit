package com.teahouse.inventory.teahouseinventory.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="employee")
@Table(name="employee")

public class Employee extends PersonEntity {
    
    @Column(name="status",nullable = false)
    private Boolean isCurrent;

    @Column(name="pan_number" )
    private String PANNumber;


    @Column(name="dob" ,nullable = false)
    private Date dateOfBirth;



    @Column(name="doj",nullable = false)
    private Date dateOfJoin;

    @Column(name="doe", nullable = false)
    private Date dateOfExit;


    @Column(name="role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles;

    @Column(name="share",nullable = false)
    private float percentageOfShare;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "franchise_id", referencedColumnName = "id")
    private Franchises franchises;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    private UserLogin userLogin;

}
