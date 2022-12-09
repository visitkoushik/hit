package com.teahouse.inventory.teahouseinventory.exceptions;

public class CreationgException extends RuntimeException{

    private String resournceNmae;
     

    public CreationgException(String resournceNmae) {
        super(String.format( "Can't create %s ", resournceNmae));
        this.resournceNmae = resournceNmae;
    
    }
    
    
}
