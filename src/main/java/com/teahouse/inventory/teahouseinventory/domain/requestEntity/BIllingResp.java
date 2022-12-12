package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.domain.enums.DiscountFormat;
import com.teahouse.inventory.teahouseinventory.util.AppUtil;

import lombok.Data;


@Data
public class BIllingResp {
    
 
    private Long id;
    private String billingDate; 
    private DiscountFormat discountFormat;
    private BigDecimal discountAmount;
    private Long franchiseId;
    private Long employeeId; 
    private List<BillingItemResp> billingItem = new ArrayList<>();
    
    



    public BIllingResp(Billing b) throws ParseException{
        this.id=b.getId();
        this.billingDate=AppUtil.DateToString(b.getBillingDate());
        this.discountFormat=b.getDiscountFormat();
        this.discountAmount = b.getDiscountAmount();
        this.franchiseId=b.getFranchiseId();
        this.employeeId=b.getEmployeeId();
            for(BillingItem br: b.getBillingItem()){
                this.billingItem.add(new BillingItemResp(br));
            }
    }
}
