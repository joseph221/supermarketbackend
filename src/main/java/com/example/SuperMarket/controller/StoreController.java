package com.example.SuperMarket.controller;

import java.util.List;

import com.example.SuperMarket.Api.StoreApi;
import com.example.SuperMarket.Dto.storedto.StoreAddDto;
import com.example.SuperMarket.Dto.storedto.StoreGetDto;
import com.example.SuperMarket.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StoreController implements StoreApi{
    @Autowired
    private StoreService storeService;
    @Override
    public void post(StoreAddDto storeAddDto) {
       storeService.add(storeAddDto);
    }

    @Override
    public List<StoreGetDto> getData() {
        return storeService.getAll();
    }

    @Override
    public void edit(StoreGetDto storeGetDto) {
        storeService.update(storeGetDto);
    }

    @Override
    public void delete(long id) {
        storeService.delete(id);
        
    }

    @Override
    public StoreGetDto fetchId(long Id) {
        return storeService.getById(Id);
    }

    @Override
    public double getStoreAmount() {
        return storeService.totalStore();
    }

    @Override
    public StoreGetDto getproducode(String producode) {
        return storeService.getBycode(producode);
    }
    
}
