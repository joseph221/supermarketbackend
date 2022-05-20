package com.example.SuperMarket.controller;

import java.util.*;

import com.example.SuperMarket.Api.UsersApi;
import com.example.SuperMarket.Dto.UserDto;
import com.example.SuperMarket.model.Users;
import com.example.SuperMarket.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@Data
@CrossOrigin
public class UsersController implements UsersApi{
    @Autowired
    private final UserService userService;

    @Override
    public List<Users> getData() {
        return userService.getAll();
    }

    @Override
    public void post(UserDto userDto){
        userService.save(userDto);
    }

    @Override
    public Optional<Users> getById(Long id) {
        
        return userService.getById(id);
    }

    @Override
    public void edit(Users users) {
       
        userService.update(users);
    }

    @Override
    public void delete(Long id) {
       
        userService.delete(id);
    }

    
}
