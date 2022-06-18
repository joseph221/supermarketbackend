package com.example.SuperMarket.model;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SuperMarket.Repository.CompanyConfRepository;

@Configuration
public class Constants {
   
    @Bean
   CommandLineRunner commandLineRunner(CompanyConfRepository companyConfRepository){
       return args ->{
            Optional<CompanyConfiguration> isPresent = companyConfRepository.getCompanyConfig();
            if(isPresent.isEmpty()){
                CompanyConfiguration intials = new CompanyConfiguration(
                    "Lavena supermarket",
                    0.15,
                    "Ilemela",
                    "0717693460",
                    "Mwanza"
                );
                companyConfRepository.save(intials);
            }
       };
   }

   
}
