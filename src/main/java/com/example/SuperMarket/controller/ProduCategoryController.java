package com.example.SuperMarket.controller;

import java.util.List;

import com.example.SuperMarket.Api.ProduCategoryApi;
import com.example.SuperMarket.Dto.ProduCtegoryDto;
import com.example.SuperMarket.service.ProduCategoriyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProduCategoryController implements ProduCategoryApi{
  @Autowired
    private ProduCategoriyService produCategoriyService;

    @Override
    public void post(ProduCtegoryDto produCtegoryDto) {
      produCategoriyService.addCategory(produCtegoryDto);
        
    }

    @Override
    public List<ProduCtegoryDto> getData() {
        List<ProduCtegoryDto> produCtegoryDto = produCategoriyService.getCategories();
        return produCtegoryDto;
    }

    @Override
    public ProduCtegoryDto getByCatId(int cid) {
      return produCategoriyService.getByCategoryId(cid);
    }

    @Override
    public void edit(ProduCtegoryDto produCtegoryDto) {
      produCategoriyService.editCategory(produCtegoryDto);
      
    }

    @Override
    public void delete(int id) {
      produCategoriyService.delete(id);
    }

    @Override
    public long getCatNum() {
      return produCategoriyService.NumberOfCategories();
    }

}
