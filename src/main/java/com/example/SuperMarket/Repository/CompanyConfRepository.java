package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.CompanyConfiguration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyConfRepository extends JpaRepository<CompanyConfiguration,Long>{
    @Query(value = "select * from company_configuration",nativeQuery = true)
    Optional<CompanyConfiguration> getCompanyConfig();
}
