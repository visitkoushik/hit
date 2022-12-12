package com.teahouse.inventory.teahouseinventory.domain;



 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.teahouse.inventory.teahouseinventory.domain.baseentities.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="client")
@Table(name="client")
public class Client extends PersonEntity {
     
 
    @OneToMany  (cascade = CascadeType.ALL,mappedBy = "client")
    private List<ClientAddress> addresses = new ArrayList<>();

    

}
