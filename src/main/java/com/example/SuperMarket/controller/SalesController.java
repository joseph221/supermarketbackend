package com.example.SuperMarket.controller;

import java.time.LocalDate;
import java.util.List;

import com.example.SuperMarket.Api.SalesApi;
import com.example.SuperMarket.Dto.SalesDto;
import com.example.SuperMarket.service.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin
@Data
public class SalesController implements SalesApi{

    @Autowired
    private final SalesService salesService;

    @Override
    public void post(SalesDto salesDto) {
        salesService.addSales(salesDto);
    }

    @Override
    public List<SalesDto> getData() {
        return salesService.getSales();
    }

    @Override
    public SalesDto getBySaleNum(int saleNum) {
        return salesService.getBySalesId(saleNum);
    }

    @Override
    public void edit(SalesDto salesDto) {
        salesService.edit(salesDto);
        
    }

   
    @Override
    public double getTotal() {
        return salesService.getTotalSales();
    }

    @Override
    public List<SalesDto> getSalesCreatedData(LocalDate start, LocalDate end) {
        return salesService.getByCreatedData(start, end);
    }
    
}
