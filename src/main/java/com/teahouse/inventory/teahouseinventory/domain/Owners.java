package com.teahouse.inventory.teahouseinventory.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.baseentities.StuffEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="owners")
@Table(name="owners")

public class Owners extends StuffEntity {
      
    @Column(name="share",nullable = false)
    private float percentageOfShare;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "franchise_id", referencedColumnName = "id")
    private List<Franchises> franchises = new ArrayList<>();




}
