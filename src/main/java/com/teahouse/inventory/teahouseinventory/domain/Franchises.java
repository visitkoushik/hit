package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="entity")
@Entity
public class Franchises extends BaseEntity{
    
    private String name;
    @Column(name="address",nullable = false)
    private Address address;

    @ManyToMany
    @JoinTable(name="franchise_owner",
    joinColumns = @JoinColumn(name="franchise_id"),
    inverseJoinColumns = @JoinColumn(name="emp_owner_id"))
    @Column(name="emp_owner",nullable = false)
    private List<Employee> owners = new ArrayList<>();

    @Column(name="tan_number")
    private String tanNumder;


    @Column(name="status")
    private Boolean isCurrent;


}
