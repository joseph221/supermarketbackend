package com.example.SuperMarket.Dto;


import lombok.Data;

@Data
public class ReceiptDto {
    private String producode;
    private String ItemName;
    private int qty;
    private long price;
    private String CashierName;
    private long receiptNo;

}
