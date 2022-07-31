package com.example.SuperMarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.SuperMarket.Dto.storedto.StoreAddDto;
import com.example.SuperMarket.Dto.storedto.StoreGetDto;
import com.example.SuperMarket.Repository.StoreRepository;
import com.example.SuperMarket.model.Store;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class StoreService {
    private final StoreRepository storeRepository;
    private final ModelMapper mapper;

    public List<StoreGetDto> getAll(){
        List<Store> stores = storeRepository.findAll();
        List<StoreGetDto> storeGetDtos = new ArrayList<>();
        for (Store store : stores) {
            storeGetDtos.add(mapper.map(store,StoreGetDto.class));
        }
        return storeGetDtos; 
    }

    public void add(StoreAddDto storeAddDto){
        Optional<Store> isPres = storeRepository.getProductcode(storeAddDto.getProducode());
        if(isPres.isPresent()){
            Store store = isPres.get();
            store.setQty(store.getQty()+storeAddDto.getQty());
            store.setAmount(store.getQty()*storeAddDto.getPrice());
            storeRepository.save(store);
        }else{
            Store store = mapper.map(storeAddDto, Store.class);
            store.setAmount(storeAddDto.getPrice()* storeAddDto.getQty());
            storeRepository.save(store);
        }
       
    }

    public StoreGetDto getById(long id){
        Store store = storeRepository.getById(id);
        StoreGetDto storeGetDto = mapper.map(store,StoreGetDto.class);
        return storeGetDto;
    }

    public void update(StoreGetDto storeGetDto){
        Store store = mapper.map(storeGetDto, Store.class);
        store.setAmount(storeGetDto.getPrice()* storeGetDto.getQty());
        storeRepository.save(store);
    }

    public void delete(long id){
        storeRepository.deleteById(id);
    }

    public double totalStore(){
        double total = 0;
        if (storeRepository.totalInventory() != null) {
            total = storeRepository.totalInventory();
        }
        return total;
    }

    public StoreGetDto getBycode(String producode){
        Optional<Store> isPres = storeRepository.getProductcode(producode);
        StoreGetDto storeGetDto = new StoreGetDto();
        if(isPres.isPresent()){
            storeGetDto = mapper.map(isPres.get(), StoreGetDto.class);
        }
        return storeGetDto;
    }

}
