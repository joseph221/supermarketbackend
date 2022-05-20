package com.example.SuperMarket.Api;

import java.util.List;

import com.example.SuperMarket.model.CompanyConfiguration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RequestMapping(path = "config")
public interface CompanyConfigApi {
    
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody CompanyConfiguration companyConfiguration);

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public CompanyConfiguration getConfig();

    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<CompanyConfiguration> getAllConfig();

}
