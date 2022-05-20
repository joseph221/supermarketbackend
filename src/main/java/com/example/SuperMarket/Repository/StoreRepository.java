package com.example.SuperMarket.Repository;

import java.util.Optional;

import com.example.SuperMarket.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store,Long>{
    
    @Query(value = "select sum(s.amount) from store s",nativeQuery = true)
    Double totalInventory();

    @Query(value = "select * from store where producode=?1",nativeQuery = true)
    public Optional<Store> getProductcode(String producode);
}
