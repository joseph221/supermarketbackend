package com.example.SuperMarket.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.SuperMarket.Dto.ReceiptDto;
import com.example.SuperMarket.Dto.SalesDto;
import com.example.SuperMarket.Repository.RecieptRepository;
import com.example.SuperMarket.Repository.SalesRepository;
import com.example.SuperMarket.Repository.StoreRepository;
import com.example.SuperMarket.model.Receipt;
import com.example.SuperMarket.model.Store;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class ReceiptService {

    private final RecieptRepository recieptRepository;
    private final StoreRepository storeRepository;
    private final SalesRepository salesRepository;
    private final SalesService salesService;
    private final ModelMapper mapper;

    public ResponseEntity addReciept(List<ReceiptDto> receiptDto) {
        String message = "";

        for (ReceiptDto rsdto : receiptDto) {
            Optional<Store> isPres = storeRepository.getProductcode(rsdto.getProducode());
            if (isPres.isPresent()) {
                Store store = isPres.get();
                message = store.getProducode().toString();
                if (store.getQty() > 0) {
                    // update store
                    store.setQty(store.getQty() - rsdto.getQty());
                    store.setAmount(store.getQty() * rsdto.getPrice());
                    storeRepository.save(store);

                    // add sales
                    Receipt receipt = mapper.map(rsdto, Receipt.class);
                    receipt.setCreatedDate(LocalDate.now());
                    receipt.setModifyDate(LocalDate.now());
                    receipt.setAmount(rsdto.getPrice() * rsdto.getQty());
                    receipt.setDate(LocalDate.now());
                    recieptRepository.save(receipt);
                    SalesDto salesDto = mapper.map(receipt, SalesDto.class);
                    salesService.addSales(salesDto);
                    message = "Take your reciept";
                    System.out.println(message);
                } else {
                    message = "The quantity of this product is below the minimum stock no sales can be made";
                    System.out.println(message);
                }
            } else {
                message = "We dont have such product in the store";
            }

        }
        Map<String,String> response = new HashMap<String,String>();
        response.put("response",message);
        return ResponseEntity.ok().body(response);
       

    }

    public ReceiptDto getByrId(int id) {

        Receipt receipt = recieptRepository.getById(id);
        ReceiptDto receiptDto = mapper.map(receipt, ReceiptDto.class);
        return receiptDto;
    }

    public List<ReceiptDto> getByreceiptNo(long receiptNo) {

        List<Receipt> receipt = recieptRepository.receiptNo(receiptNo);
        List<ReceiptDto> receiptDtos = new ArrayList<>();

        for (Receipt receipt2 : receipt) {
            receiptDtos.add(mapper.map(receipt2, ReceiptDto.class));
        }
        return receiptDtos;
    }

    public void editReceipt(ReceiptDto receiptDto) {
        Receipt receipt = mapper.map(receiptDto, Receipt.class);
        receipt.setModifyDate(LocalDate.now());
        recieptRepository.save(receipt);

    }

    public List<ReceiptDto> getAllReceipt() {
        List<Receipt> receipts = recieptRepository.findAll();
        List<ReceiptDto> receiptDtos = new ArrayList<>();
        for (Receipt receipt : receipts) {
            receiptDtos.add(mapper.map(receipt, ReceiptDto.class));
        }
        return receiptDtos;

    }

    public void deleteById(int id) {
        recieptRepository.deleteById(id);
    }

}
