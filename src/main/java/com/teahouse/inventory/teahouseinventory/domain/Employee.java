package com.teahouse.inventory.teahouseinventory.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
public class Employee extends BaseEmployee{
    @Column(name="emp_role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles = Roles.EMP;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "franchise_id", referencedColumnName = "id")
    private Franchises franchises;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee")
    private UserLogin userLogin; 

}
