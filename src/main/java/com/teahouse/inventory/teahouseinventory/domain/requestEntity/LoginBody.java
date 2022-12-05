package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {
    private String userid;
    private String passcode;
    
}
