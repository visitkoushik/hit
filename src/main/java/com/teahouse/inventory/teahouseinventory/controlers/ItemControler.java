package com.teahouse.inventory.teahouseinventory.controlers;
 
import java.util.Date;
import java.util.List; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.teahouse.inventory.teahouseinventory.domain.Item;
import com.teahouse.inventory.teahouseinventory.domain.ItemPricing;
import com.teahouse.inventory.teahouseinventory.domain.requestEntity.ItemRequest;
import com.teahouse.inventory.teahouseinventory.services.ItemEntityService;
import com.teahouse.inventory.teahouseinventory.services.ItemPricingService; 

@RestController
@RequestMapping("api/item/{loginKeyid}")
public class ItemControler extends BaseControler<ItemRequest>{
    

    private final ItemEntityService itemService;
    private final ItemPricingService itemPricingService;

    public ItemControler(ItemEntityService itemService,
    ItemPricingService itemPricingService) {
        this.itemService = itemService;
        this.itemPricingService = itemPricingService;
    }

    @Override
    public ResponseEntity onAdd(ItemRequest t) {
        ItemPricing itp =  new ItemPricing(t.getPurchaseAmount(),t.getSellingAmount(),
                new Date()); 
                itp=this.itemPricingService.save(itp);
                Item item =new Item(
                    t.getItemName(),
                    t.getDescription(),
                    t.getAvailable(),
                    t.getCategories() ,
                    itp
               );
              
            return new ResponseEntity<Item>(this.itemService.save(item), 
            HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity onUpdate(Long id, ItemRequest t) {
        ItemPricing itp =  new ItemPricing(t.getPurchaseAmount(),t.getSellingAmount(),
                new Date()); 
                itp=this.itemPricingService.save(itp);
                Item item =new Item(
                    t.getItemName(),
                    t.getDescription(),
                    t.getAvailable(),
                    t.getCategories() ,
                    itp
               );
            if(this.itemService.findById(id)!=null){
                return new ResponseEntity<Item>(this.itemService.update(item,id), 
                HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<String>(
                "Record not found", 
            HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity onFindAll(Boolean active) {
            if(active==null){
                return   new ResponseEntity<List<Item>> 
                (this.itemService.findAll(), HttpStatus.OK);
            }else{
                return   new ResponseEntity<List<Item>> 
                (this.itemService.findByStatus(active), HttpStatus.OK);
            }
    }

    @Override
    public ResponseEntity onFindById(Long id) {
        return   new ResponseEntity<Item> 
        (this.itemService.findById(id), HttpStatus.OK);
    }

    
    
   
}
