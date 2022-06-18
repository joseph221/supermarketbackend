package com.example.SuperMarket.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.SuperMarket.Dto.Chartdata;
import com.example.SuperMarket.Dto.OderByMonth;
import com.example.SuperMarket.Dto.SalesDto;
import com.example.SuperMarket.Repository.SalesRepository;
import com.example.SuperMarket.model.Sales;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final ModelMapper mapper;
    
    public void addSales(SalesDto salesDto){
        Sales sales = mapper.map(salesDto, Sales.class);
        sales.setCreatedDate(LocalDate.now());
        sales.setModifyDate(LocalDate.now());
        System.out.println(sales);
        salesRepository.save(sales);
    }

    public List<SalesDto> getSales(){
        List<Sales> sales = salesRepository.findAll();
        List<SalesDto> salesDtos = new ArrayList<>();
        for (Sales s : sales ) {
            salesDtos.add(mapper.map(s, SalesDto.class));
        }
        return salesDtos;
    }

    public SalesDto getBySalesId(int salesId){
        Sales sales = salesRepository.getById(salesId);
        SalesDto salesDto = mapper.map(sales, SalesDto.class);
        return salesDto;
    }

    public void edit(SalesDto salesDto){
        Sales sales = mapper.map(salesDto, Sales.class);
        sales.setModifyDate(LocalDate.now());
        salesRepository.save(sales);
    }


    public void delete(int salesId){
        salesRepository.deleteById(salesId);
    }

    public double getTotalSales(){
        double total = 0;
        if (salesRepository.sumAmount() != null) {
            total = salesRepository.sumAmount();
        }
        return total;
    }

    public List<SalesDto> getByCreatedData(LocalDate date1,LocalDate date2){
        List<Sales> sales = salesRepository.getByDate(date1,date2);
        List<SalesDto> salesDtos = new ArrayList<>();
        for (Sales s : sales) {
            salesDtos.add(mapper.map(s, SalesDto.class));
        }
        return salesDtos;
    }

    public List<OderByMonth> oderByMonths(){
        return salesRepository.orderByMonth();
    }

    public Chartdata chart(){
        return salesRepository.getChartdata();
    }

   
}
