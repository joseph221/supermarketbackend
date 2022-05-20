package com.example.SuperMarket.Dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductListDto2 {
    private String producode;
    private String ItemName;
    private int cat_id;
    private String type;
    private String Brand;
    private String uom;
    private Long price;
    private Long cost;
    private MultipartFile imgBytes;
}
