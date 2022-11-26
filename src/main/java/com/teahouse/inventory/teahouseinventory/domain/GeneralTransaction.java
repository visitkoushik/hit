package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="general_transaction")
public class GeneralTransaction extends BaseEntity{
    


    @Column(name="perticulars")
    private String perticulars;
    @Column(name="dr")
    private BigDecimal expenseAmount;
    @Column(name="cr")
    private BigDecimal incomeAmount;
    @Column(name="date")
    private Date date;


}
