package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.enums.OwnerType;

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
public class OwnerEntity extends PersonEntity {
    
    @Column(name="pan_number",nullable = false)
    private String PANNumber;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="share",nullable = false)
    private Short percentageOfShare;

    @Column(name="status",nullable = false)
    private Boolean isCurrent;


    @Column(name="owner_type",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private OwnerType ownerType;
}
