package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.CompanyConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyConfRepository extends JpaRepository<CompanyConfiguration,Long>{
    
}
