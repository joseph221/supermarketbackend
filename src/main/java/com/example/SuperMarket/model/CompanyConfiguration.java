package com.example.SuperMarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CompanyConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company_name;
    private double tax_rate;
    private String address;
    private String phone;
    private String city;

    public CompanyConfiguration(String company_name, double tax_rate, String address, String phone, String city) {
        this.company_name = company_name;
        this.tax_rate = tax_rate;
        this.address = address;
        this.phone = phone;
        this.city = city;
    }

    public CompanyConfiguration() {
    }

    

    
    
}
