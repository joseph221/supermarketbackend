package com.example.SuperMarket.service;

import java.util.List;

import com.example.SuperMarket.Repository.CompanyConfRepository;
import com.example.SuperMarket.model.CompanyConfiguration;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class CompanyService {
    private final CompanyConfRepository companyConfRepository;

    public void Add(CompanyConfiguration companyConfiguration){
        companyConfRepository.save(companyConfiguration);
    }

    public CompanyConfiguration getConfig(){
        List<CompanyConfiguration> companyConfigurations =companyConfRepository.findAll();
        CompanyConfiguration companyConfiguration = new CompanyConfiguration();
        for (CompanyConfiguration con : companyConfigurations) {
            companyConfiguration = con;
        }
        return companyConfiguration;
    }
    public List<CompanyConfiguration> getAll(){
        return companyConfRepository.findAll();
    }
}
