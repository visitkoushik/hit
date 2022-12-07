package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.domain.enums.DiscountFormat;

import lombok.Data;


@Data
public class BIllingResp {
    
 
    private Long id;
    private Date billingDate; 
    private DiscountFormat discountFormat;
    private BigDecimal discountAmount;
    private Long franchiseId;
    private Long employeeId; 
    private List<BillingItemResp> billingItem = new ArrayList<>();
    
    



    public BIllingResp(Billing b){
        this.id=b.getId();
        this.billingDate=b.getBillingDate();
        this.discountFormat=b.getDiscountFormat();
        this.discountAmount = b.getDiscountAmount();
        this.franchiseId=b.getFranchiseId();
        this.employeeId=b.getEmployeeId();
            for(BillingItem br: b.getBillingItem()){
                this.billingItem.add(new BillingItemResp(br));
            }
    }
}
