package com.teahouse.inventory.teahouseinventory.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="item_pricing")
public class ItemPricing extends BaseEntity{

    @Column(name="purchase_amount")
    private BigDecimal purchaseAmount;
    @Column(name="selling_amount")
    private BigDecimal sellingAmount;
    @Column(name="update_date")
    private Date updateDate;

     
}
