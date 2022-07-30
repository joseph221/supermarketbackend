package com.example.SuperMarket.controller;

import java.io.UnsupportedEncodingException;
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
        try {
            userService.save(userDto);
        } catch (UnsupportedEncodingException e) {
    
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Users> getById(Long id) {
        
        return userService.getById(id);
    }

    @Override
    public void edit(UserDto userDto) {
       
        userService.update(userDto);
    }

    @Override
    public void delete(Long id) {
       
        userService.delete(id);
    }

    @Override
    public Users logins(String username, String password) {
        return userService.login(username, password);
    }

    
}
