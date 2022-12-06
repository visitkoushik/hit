package com.teahouse.inventory.teahouseinventory.controlers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.services.BillingItemService;
import com.teahouse.inventory.teahouseinventory.services.BillingService;

@RestController
@RequestMapping("api/bill/{loginKeyid}")
public class BillingControl extends BaseControler<Billing>{


    private final BillingService billingService;
    private final BillingItemService billingItemService;

    public BillingControl(BillingService billingService, 
    BillingItemService billingItemService) {
        this.billingService = billingService;
        this.billingItemService = billingItemService;
    }

    @Override
    public ResponseEntity onAdd( Billing t) {
        // TODO Auto-generated method stub
       t.setBillingDate(new Date());  
       Billing b = this.billingService.save(t);

       List<BillingItem> bts=b.getBillingItem();
       for (int i=0;i<bts.size();i++){
            BillingItem bt = bts.get(i);
            bt.setBilling(b);
            this.billingItemService.save(bt);
       }
        return new ResponseEntity<String>("Hoeche Bal add ",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Billing t) {
        // TODO Auto-generated method stub
        return new ResponseEntity<String>("Hoeche Bal update ",HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity onFindById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
 

    

    
}
