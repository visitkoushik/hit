package com.teahouse.inventory.teahouseinventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resournceNmae;
    private String fieldNmae;
    private Object fieldValue;

    public ResourceNotFoundException(String resournceNmae, String fieldNmae, Object fieldValue) {
        super(String.format( "%s not fount with %s: %s", resournceNmae,fieldNmae,fieldValue));
        this.resournceNmae = resournceNmae;
        this.fieldNmae = fieldNmae;
        this.fieldValue = fieldValue;
    }
    

}