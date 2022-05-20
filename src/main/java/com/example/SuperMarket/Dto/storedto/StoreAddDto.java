package com.example.SuperMarket.Dto.storedto;

import lombok.Data;

@Data
public class StoreAddDto {
    private String producode;
    private double price;
    private int qty;
    private int minimum_qty;
}
