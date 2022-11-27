package com.teahouse.inventory.teahouseinventory.domain;



 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class Client extends PersonEntity {
    
    @Column(name="client_role",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Roles roles = Roles.CLIENT;

}
