package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
// @AllArgsConstructor
// @NoArgsConstructor
@Entity(name="emp_address")
@Table(name="emp_address")
public class EmployeeAddress extends Address{
    


    
   

}
