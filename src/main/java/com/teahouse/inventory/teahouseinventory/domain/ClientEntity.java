package com.teahouse.inventory.teahouseinventory.domain;



import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
// @AllArgsConstructor
@Entity
public class ClientEntity extends PersonEntity {
    


}
