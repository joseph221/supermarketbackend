package com.example.SuperMarket.Dto;

import org.springframework.web.multipart.MultipartFile;

public interface ProductWithCategoryName {
    String getProducode();
    String getItemName();
     int getCat_id();
     String getType();
     String getBrand();
     String getUom();
     Long getPrice();
     Long getCost();
     MultipartFile getImgBytes();
    String getCategoryName();
}
