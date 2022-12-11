package com.teahouse.inventory.teahouseinventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity(name = "category")
@Table(name = "category")
public class Category extends BaseEntity{
    

    private String categoryName;

    @Column(name="status",nullable = false)
    private boolean available;
}