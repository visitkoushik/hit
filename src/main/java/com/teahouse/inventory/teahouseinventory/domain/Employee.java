package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.baseentities.StuffEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="employee")
@Table(name="employee")

public class Employee extends StuffEntity {
 
 

    @Column(name="salary",nullable = false)
    private float salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "franchise_id", referencedColumnName = "id")
    private Franchises franchises;



}
