package com.example.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Receipt extends Audit{
    @Id
    @GeneratedValue
    private int id;
    private String producode;
    private String ItemName;
    private int qty;
    private long price;
    private double Amount;
    private LocalDate date;
    private String CashierName;
    private long receiptNo;
}
