package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.ProduCategories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduCategoryRepository extends JpaRepository<ProduCategories,Integer>{
    
}
