package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.teahouse.inventory.teahouseinventory.domain.enums.DiscountFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="billings")
@Table(name="billing")
public class Billing extends BaseEntity{

    @Column(name="date")
    private Date billingDate;

    

    @Column(name="billing_item")
    @ManyToMany
    @JoinTable(name="item_billing",
    joinColumns = @JoinColumn(name="billing_id"),
    inverseJoinColumns =  @JoinColumn(name = "item_id"))
    private List<BillingItem> itemEntites = new ArrayList<>();

    @Column(name="discount_mode")
    @Enumerated(value=EnumType.STRING)
    private DiscountFormat discountFormat;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @ManyToOne
    private Franchises franchises;

    @ManyToOne
    private Employee employee;    
}
