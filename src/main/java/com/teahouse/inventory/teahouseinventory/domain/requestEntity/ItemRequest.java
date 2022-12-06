package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Category;

import lombok.Data; 

@Data
public class ItemRequest {
    
    private String itemName; 
    private String description; 
    private Boolean available; 
    private List<Category> categories= new ArrayList<>();
    private BigDecimal purchaseAmount;
    private BigDecimal sellingAmount; 
 
}
