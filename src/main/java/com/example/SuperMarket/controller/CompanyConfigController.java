package com.example.SuperMarket.controller;

import java.util.List;

import com.example.SuperMarket.Api.CompanyConfigApi;
import com.example.SuperMarket.model.CompanyConfiguration;
import com.example.SuperMarket.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyConfigController implements CompanyConfigApi{

    @Autowired
    private CompanyService companyService;

    @Override
    public void post(CompanyConfiguration companyConfiguration) {
        companyService.Add(companyConfiguration);
        
    }

    @Override
    public CompanyConfiguration getConfig() {
        return companyService.getConfig();
    }

    @Override
    public List<CompanyConfiguration> getAllConfig() {
        return companyService.getAll();
    }
    
}
