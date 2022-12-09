package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="fanchise_address")
@Table(name="fanchise_address")
public class FranchiseAddress extends Address{
    @OneToOne
    private Franchises franchise;
}
