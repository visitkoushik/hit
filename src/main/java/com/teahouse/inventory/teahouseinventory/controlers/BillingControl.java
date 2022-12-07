package com.teahouse.inventory.teahouseinventory.controlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teahouse.inventory.teahouseinventory.domain.Billing;
import com.teahouse.inventory.teahouseinventory.domain.BillingItem;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.BIllingResp;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.BillingItemResp;
import com.teahouse.inventory.teahouseinventory.services.BillingItemService;
import com.teahouse.inventory.teahouseinventory.services.BillingService;
import com.teahouse.inventory.teahouseinventory.util.AppUtil;

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
    //    return new ResponseEntity<Billing>(b,HttpStatus.CREATED);
        return new ResponseEntity<String>("Bill Stored Successfully",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, Billing t) {
       
        return new ResponseEntity<String>("Update Service Unavailable",HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
        
        List<Billing> b = this.billingService.findAll(); 

        List<BIllingResp>  billingResp=new ArrayList<>();
        for(Billing br: b){
            try {
                billingResp.add(new BIllingResp(br));
            } catch (ParseException e) {
                
                return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
           
        }

        return new ResponseEntity<List<BIllingResp>>(billingResp,HttpStatus.OK);
    }

    @Override
    public ResponseEntity onFindById(Long id) {
        
        Billing b = this.billingService.findById(id);
        if(b!=null){
            try {
                return new ResponseEntity<BIllingResp>(new BIllingResp(b),HttpStatus.OK);
            } catch (ParseException e) {
                
                return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
        else{
            return new ResponseEntity<String>("Found No such bill", HttpStatus.OK);
        }
     
    }
 
    //dd/mm/yyyy HH:mm:ss
    @GetMapping("listbydate")
    public ResponseEntity findByDate(
        @RequestParam("start") String startDate,
        @RequestParam("end") String endDate

    ) {
        try{
            Date sDt = AppUtil.StringToDate(startDate);
            Date eDt =  AppUtil.StringToDate(endDate);
            
            List<Billing> list= this.billingService.findByDateRange(sDt, eDt);

            List<BIllingResp> bs = new ArrayList<>();
            for (Billing b:list){
                bs.add(new BIllingResp(b));
            }
            return new ResponseEntity<List<BIllingResp>>
             (bs,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>
            ("Date Formate should be 'yyyy-MM-dd'T'HH:mm:ss.SSSZ'",HttpStatus.BAD_REQUEST);
        }
      
    }

    
}
