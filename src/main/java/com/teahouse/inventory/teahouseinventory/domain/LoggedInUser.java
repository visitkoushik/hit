package com.teahouse.inventory.teahouseinventory.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="logged_user")
@Entity(name="logged_user")
public class LoggedInUser extends BaseEntity{
    

     
    
    @OneToOne(mappedBy = "loggedinuser")
    private UserLogin userlogin;
 

    @Column(name="status")
    private boolean isLoggedin;
    
    @Column(name="expiredate")
    private Date expireDate;

    @Column(name="auth_key")
    private String authKey;

    
}
