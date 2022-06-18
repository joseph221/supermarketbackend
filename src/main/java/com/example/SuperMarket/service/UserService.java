package com.example.SuperMarket.service;

import java.util.*;

import com.example.SuperMarket.Dto.UserDto;
import com.example.SuperMarket.Repository.RoleRepository;
import com.example.SuperMarket.Repository.UsersRepository;
import com.example.SuperMarket.model.Roles;
import com.example.SuperMarket.model.Users;

import org.modelmapper.ModelMapper;


import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class UserService{
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;

    public void save(UserDto userDto){
        System.out.println(userDto);
        Users user = mapper.map(userDto,Users.class);
        List<Roles> roles = roleRepository.getByRoleId(userDto.getRoleId());
        user.setRoles(roles);
        usersRepository.save(user);

    }

    public List<Users> getAll(){
       List<Users> users = usersRepository.findAll();
       return users;
    }

    public Optional<Users> getById(Long id){
        Optional<Users> user = usersRepository.findById(id);
        return user;
    }

    public void update( Users users){
        usersRepository.save(users);

    }
    public void delete(Long id ){
        usersRepository.deleteById(id);
    }

    public Users login(String username,String password){
        return usersRepository.getLogins(username, password);
    }
}
