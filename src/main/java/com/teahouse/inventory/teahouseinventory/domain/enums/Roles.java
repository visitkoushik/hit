package com.teahouse.inventory.teahouseinventory.domain.enums;

public enum Roles {
    SUPERADMIN(1), //READ WRITE ALL TABEL ALL RECORDS
    ADMIN(2), //READ WRITE ALL TABLE AND RECORDS ONLY ASSOCIATE FRANCHISE
    READ(3),//ONLY READALL TABLE
    EMP(4),   // LIMITED PRIVILEDGE
    INVENTORYREAD(5), // ONLY ABLE TO READ ITEMS AND ITS SELLING PRICE
    CLIENT(6);// ONLY ABLE TO READ ITEMS AND ITS SELLING PRICE NO OTHER CHANGE

    private final int value; 
    private Roles(int value) { this.value = value; } 

    public int getValue() {
        return value;
    }

}
