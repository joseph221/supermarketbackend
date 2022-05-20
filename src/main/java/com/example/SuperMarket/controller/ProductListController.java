package com.example.SuperMarket.controller;

import java.io.IOException;
import java.util.List;

import com.example.SuperMarket.Api.ProductListApi;
import com.example.SuperMarket.Dto.ProductListDto;
import com.example.SuperMarket.Dto.ProductListDto2;
import com.example.SuperMarket.service.ProductListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ProductListController implements ProductListApi {
    @Autowired
    private ProductListService productListService;

    @Override
    public List<ProductListDto> getData() {
        
        return productListService.getPoduct();
    }

    @Override
    public ProductListDto getproducode(String producode) {
       
        return productListService.getByPproducode(producode);
    }

    @Override
    public void edit(ProductListDto productListDto) {

        productListService.edit(productListDto);
        
    }

    @Override
    public long getProNum() {
        return productListService.NumberOfProducts();
    }

    @Override
    public void delete(String id) {
        productListService.delete(id);
    }

    @Override
    
    public void post(ProductListDto2 productListDto2) throws IOException {
        productListService.addProduct(productListDto2);
        
    }
}
