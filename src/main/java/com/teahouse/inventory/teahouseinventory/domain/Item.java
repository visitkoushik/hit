package com.teahouse.inventory.teahouseinventory.domain;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.baseentities.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="item")
@Table(name="items")
public class Item extends BaseEntity
{

    @Column(name="item_name")
    private String itemName;
    @Column(name="description")
    private String description;
    @Column(name="status",nullable = false)
    private Boolean available;

    @Column(name="category",nullable = false)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="item_category",
    joinColumns = @JoinColumn(name="item_id"),
    inverseJoinColumns =  @JoinColumn(name = "category_id"))
    private List<Category> categories= new ArrayList<>();

 
 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_price_id", referencedColumnName = "id")
     private ItemPricing itemPricingEntity;
}
