package com.example.SuperMarket.service;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

import com.example.SuperMarket.Dto.ProductListDto;
import com.example.SuperMarket.Dto.ProductListDto2;
import com.example.SuperMarket.Dto.ProductWithCategoryName;
import com.example.SuperMarket.Repository.ProductListRepository;
import com.example.SuperMarket.model.ProductList;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import lombok.Data;

@Data
@Service
public class ProductListService {

    private final ProductListRepository productListRepository;
    private final ModelMapper mapper;
    
    public void addProduct(ProductListDto2 productListDto2) throws IOException{
        ProductList productList = mapper.map(productListDto2, ProductList.class);
        productList.setPicByte(Base64.getEncoder().encodeToString(productListDto2.getImgBytes().getBytes()));
        productList.setCreatedDate(LocalDate.now());
        productList.setModifyDate(LocalDate.now());
        productListRepository.save(productList);

    }

    public List<ProductListDto> getPoduct(){
        List<ProductList> productLists = productListRepository.findAll();
        List<ProductListDto> productListDtos = new ArrayList<>();
        for (ProductList p : productLists ) {
            
            productListDtos.add(mapper.map(p, ProductListDto.class));
        }
        return productListDtos;
    }


    public  ProductListDto getByPproducode(String producode){
        ProductList productList = productListRepository.getById(producode);
        productList.setPicByte(productList.getPicByte());
        ProductListDto productListDto = mapper.map(productList, ProductListDto.class);
        return productListDto;
    }
    public void delete(String code){
        productListRepository.deleteById(code);
    }

    public void edit(ProductListDto2 productListDto2) throws IOException{
        ProductList productList = mapper.map(productListDto2, ProductList.class);
        productList.setPicByte(Base64.getEncoder().encodeToString(productListDto2.getImgBytes().getBytes()));
        productList.setModifyDate(LocalDate.now());
        productListRepository.save(productList);
    }

    

    public long NumberOfProducts(){
        long num= 0;
        if (productListRepository.count() != 0) {
            num = productListRepository.count();
        }
        return num;
    }

    public List<ProductListDto> getByCatId(int catId){
        List<ProductList> productLists = productListRepository.getByCatId(catId);
        List<ProductListDto> productListDtos =new  ArrayList<>();
        for (ProductList productList : productLists) {
            productListDtos.add(mapper.map(productList, ProductListDto.class));
        }
        return productListDtos;

    }

    public List<ProductWithCategoryName> getData2(){
       return  productListRepository.getProduct();
    }
}
