package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="user_login")
public class UserLogin extends BaseEntity{
    
    @Column(name="userName")
    private String userName;
    @Column(name="pass")
    private String passWord;

    @Column(name="oldpasswords")
    private String oldpass;

    @Column(name="status")
    private Boolean isActive;

    @Column(name="expiredate")
    private Date expireDate;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

}