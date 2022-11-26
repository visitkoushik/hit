package com.teahouse.inventory.teahouseinventory.domain;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.enums.OwnerType;
import com.teahouse.inventory.teahouseinventory.domain.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="owner")
@Entity
public class OwnerEntity extends EmployeeEntity {
    
 
    @Column(name="share",nullable = false)
    private Short percentageOfShare;
 

    @Column(name="owner_role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles=Roles.ADMIN;


}
