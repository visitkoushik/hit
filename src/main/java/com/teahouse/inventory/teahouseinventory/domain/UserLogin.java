package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

 

import com.teahouse.inventory.teahouseinventory.domain.enums.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name="userLogin")
@Table(name="user_login" ,  uniqueConstraints={@UniqueConstraint(columnNames ={"user_name"})})
public class UserLogin extends BaseEntity{
    
    @Column(name="user_name",nullable = false)
    private String userName;
     
    @Column(name="pass_word",nullable = false)
    private String passWord;

    @Column(name="oldpasswords")
    private String oldpass;

    @Column(name="status",nullable = false)
    private Boolean isActive;

    @Column(name= "user_type",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private UserType userType;
 

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "logged_user_id")
    private LoggedInUser loggedinuser;

}
