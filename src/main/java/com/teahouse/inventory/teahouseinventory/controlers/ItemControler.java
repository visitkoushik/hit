package com.teahouse.inventory.teahouseinventory.controlers;
 
import java.util.Date;
import java.util.List; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            return new ResponseEntity<Item>(this.itemService.update(item,id), 
        HttpStatus.ACCEPTED);
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

   

    // @PostMapping("add") 
    // public ResponseEntity add(
    // @PathVariable("loginKeyid")  String loginKey,  
    // @RequestBody ItemRequest itemRequest){
    //     if(getUserLoginId(loginKey)==null){
    //         return   new ResponseEntity<String>
    //         ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //     }
    //         ItemPricing itp =  new ItemPricing(itemRequest.getPurchaseAmount(),itemRequest.getSellingAmount(),
    //         new Date()); 
    //         itp=this.itemPricingService.save(itp);
    //         Item item =new Item(
    //             itemRequest.getItemName(),
    //             itemRequest.getDescription(),
    //             itemRequest.getAvailable(),
    //             itemRequest.getCategories() ,
    //             itp
    //        );
          
    //     return new ResponseEntity<Item>(this.itemService.save(item), 
    //     HttpStatus.CREATED);
        
    // }

    // @PutMapping("edit/{id}")
    // public ResponseEntity update(  
    //     @PathVariable("loginKeyid")  String loginKey,  
    //     @PathVariable("id") Long id, 
    //     @RequestBody Item item){
       
    //         if(getUserLoginId(loginKey)==null){
    //             return   new ResponseEntity<String>
    //             ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //         }
    //     return new ResponseEntity<Item>(this.itemService.update(item,id), 
    //     HttpStatus.ACCEPTED);
    // }




    // @GetMapping("list/all")
    // public ResponseEntity findAll(
    //     @PathVariable("loginKeyid")  String loginKey,  
    //     @RequestParam(name="active",required = false) @Nullable Boolean active
    //     ) {
    //         if(getUserLoginId(loginKey)==null){
    //             if(getUserLoginId(loginKey)==null){
    //                 return   new ResponseEntity<String>
    //                 ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //             }
    //         }
    //         if(active==null){
    //             return   new ResponseEntity<List<Item>> 
    //             (this.itemService.findAll(), HttpStatus.OK);
    //         }else{
    //             return   new ResponseEntity<List<Item>> 
    //             (this.itemService.findByStatus(active), HttpStatus.OK);
    //         }
    // }
    // @GetMapping("list")
    // public ResponseEntity findById(
    //     @PathVariable("loginKeyid")  String loginKey,  
    //     @RequestParam(name="id",required = true) Long itemId
    //     ) {

    //         if(getUserLoginId(loginKey)==null){
    //             return   new ResponseEntity<String>
    //             ("Either wrong credential or not have permission", HttpStatus.UNAUTHORIZED);
    //         }

    //     return   new ResponseEntity<Item> 
    //     (this.itemService.findById(itemId), HttpStatus.OK);
    // }

    
   
}
