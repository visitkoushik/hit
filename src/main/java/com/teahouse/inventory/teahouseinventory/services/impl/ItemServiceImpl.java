package com.teahouse.inventory.teahouseinventory.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teahouse.inventory.teahouseinventory.domain.Item;
import com.teahouse.inventory.teahouseinventory.exceptions.ResourceNotFoundException;
import com.teahouse.inventory.teahouseinventory.repositories.ItemRepository;
import com.teahouse.inventory.teahouseinventory.services.ItemEntityService;

@Service
public class ItemServiceImpl implements ItemEntityService{


    private final ItemRepository itemRpository;



    public ItemServiceImpl(ItemRepository itemRpository) {
        this.itemRpository = itemRpository;
    }

    @Override
    public List<Item> findAll() {
        
        return this.itemRpository.findAll();
    }

    @Override
    public Item findById(Long Id) {
       
        return this.itemRpository.findById(Id).orElseThrow(

            ()-> new ResourceNotFoundException("Item", "ID", Id)
        );
    }

    @Override
    public Item save(Item t) {
       
        return this.itemRpository.save(t);
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Item update(Item t, Long id) {
        Item f = this.findById(id);
        if(f!=null){
           f.setAvailable(t.getAvailable());
           f.setCategories(t.getCategories());
           f.setDescription(t.getDescription());
           f.setItemName(t.getItemName());
           f.setItemPricingEntity(t.getItemPricingEntity());
        }
        
        return this.itemRpository.save(f);
    }

    @Override
    public List<Item> findByStatus(Boolean active) {
         
        return this.itemRpository.findByStatus(active);
    }

    
    
}
