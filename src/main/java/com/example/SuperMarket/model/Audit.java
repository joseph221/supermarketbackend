package com.example.SuperMarket.model;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@MappedSuperclass
public class Audit {
    private LocalDate modifyDate;
    private LocalDate createdDate;
    private int createdBy;
}
