package com.teahouse.inventory.teahouseinventory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends BaseEntity{
    
    private String categoryName;
}