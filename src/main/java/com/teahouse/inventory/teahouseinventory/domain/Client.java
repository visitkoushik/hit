package com.teahouse.inventory.teahouseinventory.domain;



 
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
 
    @OneToMany  (cascade = CascadeType.ALL,mappedBy = "client")
    private List<ClientAddress> addresses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    private UserLogin userLogin;

}
