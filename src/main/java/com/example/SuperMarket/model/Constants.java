package com.example.SuperMarket.model;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SuperMarket.Dto.UserDto;
import com.example.SuperMarket.Repository.CompanyConfRepository;
import com.example.SuperMarket.Repository.RoleRepository;
import com.example.SuperMarket.Repository.UsersRepository;
import com.example.SuperMarket.service.UserService;

@Configuration
public class Constants {
   
    @Bean
   CommandLineRunner commandLineRunner(CompanyConfRepository companyConfRepository,
   UsersRepository usersRepository,RoleRepository roleRepository,UserService userService){
       return args ->{
            List<Roles> roles1 = roleRepository.getByRoleId(1);
            if(roles1.isEmpty()){
                Roles role = new Roles();
                role.setRoleId(1);
                role.setRoleName("Admin");
                roleRepository.save(role);
            }

            List<Users> isUserAvailable = usersRepository.isUser();
            if(isUserAvailable.isEmpty()){
                UserDto user = new UserDto();
                user.setFirstname("Admin");
                user.setLastname("Admin");
                user.setUsername("mrdavidjoseph60@gmail.com");
                user.setEmail("mrdavidjoseph60@gmail.com");
                user.setPassword("super$Admin1");
                user.setRoleId(1);
                userService.save(user);
            }

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
