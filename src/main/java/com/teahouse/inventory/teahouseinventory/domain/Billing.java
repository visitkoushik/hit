package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated; 
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Entity(name="billings")
@Table(name="billing")
public class Billing extends BaseEntity{

    @Column(name="date")
    private Date billingDate;

    
    @OneToMany  (cascade = CascadeType.ALL,mappedBy = "billing")
    private List<BillingItem> billingItem = new ArrayList<>();

    @Column(name="discount_mode")
    @Enumerated(value=EnumType.STRING)
    private DiscountFormat discountFormat;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name="franchise_id",nullable = false)
    private Long franchiseId;

    @Column(name="emp_id", nullable = false)
    private Long employeeId;    

    // @OneToOne
    // private Client client;
}
