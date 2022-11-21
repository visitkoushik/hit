package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class ItemEntity extends BaseEntity
{

    @Column(name="item_name")
    private String itemName;
    @Column(name="description")
    private String description;

    @Column(name="category")
    @ManyToMany
    @JoinTable(name="item_category",
    joinColumns = @JoinColumn(name="item_id"),
    inverseJoinColumns =  @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories= new ArrayList<>();

    
}
