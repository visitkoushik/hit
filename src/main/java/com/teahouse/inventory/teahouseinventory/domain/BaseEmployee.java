package com.teahouse.inventory.teahouseinventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)

@MappedSuperclass
public class BaseEmployee extends PersonEntity {
    
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



}
