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
@Entity(name="emp_address")
@Table(name="emp_address")
public class EmployeeAddress extends Address{
    


    @OneToOne
    private Employee employee;

}
