package com.example.SuperMarket.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Table
@Entity
@Data
public class Sales extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qty;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "producode",referencedColumnName = "producode")
    private ProductList producode;
    private double amount;
    private double price;
    private int receiptNo;
    
    
}