package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.math.BigDecimal;

import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.domain.enums.DiscountFormat;

import lombok.Data;


@Data
public class BillingItemResp {
  private Long id;
  private BigDecimal purchaseAmount;
  private BigDecimal sellingAmount;
  private BigDecimal discount;
  private DiscountFormat discountFormat;
  private Long item;
  private Short itemCount;


  public BillingItemResp(BillingItem b){
    this.id=b.getId();
    this.purchaseAmount = b.getPurchaseAmount(); 
    this.sellingAmount = b.getSellingAmount();
    this.discount = b.getDiscount();
    this.discountFormat = b.getDiscountFormat();
    this.itemCount = b. getItemCount();
  }
}
