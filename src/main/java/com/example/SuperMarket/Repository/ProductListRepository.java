package com.example.SuperMarket.Repository;


import java.util.Optional;

import com.example.SuperMarket.model.ProductList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductListRepository extends JpaRepository<ProductList,String> {
    
    @Query(value = "select s from ProductList Where s.producode =?1",nativeQuery = true)
    Optional<ProductList> findProductListByproducode(String producode);
}
