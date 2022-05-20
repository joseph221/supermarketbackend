package com.example.SuperMarket.service;

import com.example.SuperMarket.Dto.ProduCtegoryDto;
import com.example.SuperMarket.Repository.ProduCategoryRepository;
import com.example.SuperMarket.model.ProduCategories;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Data
@Service
public class ProduCategoriyService {
    
    private final ProduCategoryRepository produCategoryRepository;
    private final ModelMapper mapper;

    public void addCategory(ProduCtegoryDto produCtegoryDto){
        ProduCategories produCategories = mapper.map(produCtegoryDto, ProduCategories.class);
        produCategories.setCreatedDate(LocalDate.now());
        produCategories.setModifyDate(LocalDate.now());
        produCategoryRepository.save(produCategories);
    }

    public List<ProduCtegoryDto>  getCategories(){
        List<ProduCategories>  categoryList = produCategoryRepository.findAll();
        List<ProduCtegoryDto>  produCtegoryDtosList = new ArrayList<>();
        for (ProduCategories produ : categoryList) {
            produCtegoryDtosList.add(mapper.map(produ, ProduCtegoryDto.class));
        }
        return produCtegoryDtosList;
        
    }

    public void editCategory(ProduCtegoryDto produCtegoryDto){
        ProduCategories produCategories = mapper.map(produCtegoryDto, ProduCategories.class);
        produCategories.setModifyDate(LocalDate.now());
        produCategoryRepository.save(produCategories);
    }

    public ProduCtegoryDto getByCategoryId(int CategoryId){
        ProduCategories produCategories = produCategoryRepository.getById(CategoryId);
        ProduCtegoryDto produCtegoryDto = mapper.map(produCategories, ProduCtegoryDto.class);
        return produCtegoryDto;
    }

    public void delete(int CategoryId){
        produCategoryRepository.deleteById(CategoryId);
    }

    public long NumberOfCategories(){
        long num= 0;
        if (produCategoryRepository.count() != 0) {
            num = produCategoryRepository.count();
        }
        return num;
    }
}
