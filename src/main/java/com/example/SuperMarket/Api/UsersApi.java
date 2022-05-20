package com.example.SuperMarket.Api;

import com.example.SuperMarket.Dto.UserDto;
import com.example.SuperMarket.model.Users;

import java.util.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/user")
public interface UsersApi {
    
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody UserDto user);

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<Users> getData();

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Optional<Users> getById(@PathVariable("id") Long Id);

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@RequestBody Users users);

    @RequestMapping(path = "/delete/{id}",method = { RequestMethod.GET, RequestMethod.DELETE })
    public void delete(@PathVariable("id") Long id);
}
