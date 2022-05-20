package com.example.SuperMarket.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SalesDto {
    
    private String producode;
    private int qty;
    private String ItemName;
    private double price;
    private double Amount;
    private int receiptNo;
    private LocalDate createdDate;

}
