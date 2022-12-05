package com.teahouse.inventory.teahouseinventory.domain.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResp {
    private String authCode;
    private String error;
}
