package com.teahouse.inventory.teahouseinventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeEntity extends PersonEntity{
    @Column(name="emp_role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles = Roles.EMP;

    @Column(name="status",nullable = false)
    private Boolean isCurrent;

    @Column(name="pan_number" )
    private String PANNumber;

    @OneToOne
    private UserLogin loginInfo;



    @Column(name="dob" ,nullable = false)
    private Date dateOfBirth;



    @Column(name="doj",nullable = false)
    private Date dateOfJoin;

    @Column(name="doe", nullable = false)
    private Date dateOfExit;
}
