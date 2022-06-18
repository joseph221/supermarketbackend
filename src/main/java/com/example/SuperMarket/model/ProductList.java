package com.example.SuperMarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;


@Table
@Entity
@Data
public class ProductList extends Audit{
    @Id
    private String producode;
    private String ItemName;
    private int cat_id;
    private String type;
    private String Brand;
    private String uom;
    private Long cost;
    private Long price;
    @Lob
	private String picByte;

   
    
}
