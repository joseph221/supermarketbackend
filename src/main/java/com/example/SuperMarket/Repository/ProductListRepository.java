package com.example.SuperMarket.Repository;


import java.util.List;
import java.util.Optional;

import com.example.SuperMarket.Dto.ProductWithCategoryName;
import com.example.SuperMarket.model.ProductList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductListRepository extends JpaRepository<ProductList,String> {
    
    @Query(value = "select s from ProductList Where s.producode =?1",nativeQuery = true)
    Optional<ProductList> findProductListByproducode(String producode);

    @Query(value="select * from product_list where cat_id = ?1",nativeQuery = true)
    List<ProductList> getByCatId(int catId);

    @Query(value = "select * from product_list,produ_categories where product_list.cat_id = produ_categories.id",nativeQuery = true)
    public List<ProductWithCategoryName> getProduct();

}
