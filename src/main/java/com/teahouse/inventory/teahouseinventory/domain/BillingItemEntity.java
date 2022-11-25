package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;

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
@Table(name = "billing_item")
public class BillingItemEntity extends ItemEntity {
 

    @Column(name="purchase_amount")
    private BigDecimal purchaseAmount;
    @Column(name="selling_amount")
    private BigDecimal sellingAmount;
}
