package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.enums.DiscountFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="billingitem")
@Table(name = "billing_item")
public class BillingItem extends BaseEntity{
 

    
    @Column(name="purchase_amount")
    private BigDecimal purchaseAmount;
    @Column(name="selling_amount")
    private BigDecimal sellingAmount;
    @Column (name ="discount")
    private BigDecimal discount;
    @Column (name="discount_type")
    @Enumerated(value = EnumType.STRING)
    private DiscountFormat discountFormat;
    @Column(name="itemid")
    private Long item;
    @Column(name="item_count")
    private Short itemCount;

    @ManyToOne 
    private Billing billing;
   
}
