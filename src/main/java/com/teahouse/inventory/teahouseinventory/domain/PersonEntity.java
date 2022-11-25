package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
 
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@MappedSuperclass
public class PersonEntity extends BaseEntity{
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private Long[] mobileNumbers;
    
    @Column(name = "addresses")
    @JoinTable(name="person_address",
    joinColumns = @JoinColumn(name="person_id"),
    inverseJoinColumns = @JoinColumn(name="address_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AddressEntity> adresses = new ArrayList<>();
}
