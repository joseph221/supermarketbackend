package com.example.SuperMarket.Dto.storedto;

import lombok.Data;

@Data
public class StoreGetDto {
    private long id;
    private String producode;
    private double price;
    private int qty;
    private int minimum_qty;
    private double amount;
}
