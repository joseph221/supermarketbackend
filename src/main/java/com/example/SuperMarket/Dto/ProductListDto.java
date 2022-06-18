package com.example.SuperMarket.Dto;


import lombok.Data;

@Data
public class ProductListDto {
    private int id;
    private String producode;
    private String ItemName;
    private int cat_id;
    private String type;
    private String Brand;
    private String uom;
    private Long price;
    private Long cost;
    private String picByte;
}
