package com.example.SuperMarket.controller;

import java.util.List;

import com.example.SuperMarket.Api.ReceiptApi;
import com.example.SuperMarket.Dto.ReceiptDto;
import com.example.SuperMarket.service.ReceiptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
@CrossOrigin
public class ReceiptController implements ReceiptApi{

    @Autowired
    private ReceiptService receiptService;

    @Override
    public List<ReceiptDto> getReceipt() {
        return receiptService.getAllReceipt();
    }

    @Override
    public void post(List<ReceiptDto> receiptDto) {
       receiptService.addReciept(receiptDto);
        
    }

    @Override
    public void put(ReceiptDto receiptDto) {
        receiptService.editReceipt(receiptDto);
        
    }

    @Override
    public List<ReceiptDto> getreceiptNo(long receiptNo) {
        return receiptService.getByreceiptNo(receiptNo);
    }

}
