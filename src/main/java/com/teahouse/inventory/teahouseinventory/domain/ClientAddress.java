package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="client_address")
@Table(name="client_address")
public class ClientAddress extends Address{

    @ManyToOne
    private Client client;
}
