package com.example.SuperMarket.service;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.example.SuperMarket.Dto.UserDto;
import com.example.SuperMarket.Repository.RoleRepository;
import com.example.SuperMarket.Repository.UsersRepository;
import com.example.SuperMarket.model.Roles;
import com.example.SuperMarket.model.Users;
import com.example.SuperMarket.sha3.Sha3Util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class UserService{
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    @Autowired
    private EmailService emailService;


    public void save(UserDto userDto) throws UnsupportedEncodingException{
        System.out.println(userDto);
        Users user = mapper.map(userDto,Users.class);
        
        List<Roles> roles = roleRepository.getByRoleId(userDto.getRoleId());
        user.setRoles(roles);
        emailService.sendMail2(user.getEmail(),user.getUsername(),user.getPassword());
        byte[] shaInBytes = Sha3Util.digest(userDto.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(Sha3Util.bytesToHex(shaInBytes));
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

    public void update(UserDto userDto){
        Users user = mapper.map(userDto,Users.class);
        List<Roles> roles = roleRepository.getByRoleId(userDto.getRoleId());
        user.setRoles(roles);
        usersRepository.save(user);

    }
    public void delete(Long id ){
        usersRepository.deleteById(id);
    }

    public Users login(String username,String password){
        byte[] sha3Bytes = Sha3Util.digest(password.getBytes(StandardCharsets.UTF_8));
        String encrypted = Sha3Util.bytesToHex(sha3Bytes);
        return usersRepository.getLogins(username, encrypted);
    }
    public Users currentUser(String currentpass){
        byte[] sha3Bytes = Sha3Util.digest(currentpass.getBytes(StandardCharsets.UTF_8));
        String encrypted = Sha3Util.bytesToHex(sha3Bytes);
        return usersRepository.CurrentPassword(encrypted);
    }

    public void changePassword(String pass,long id){
        byte[] sha3Bytes = Sha3Util.digest(pass.getBytes(StandardCharsets.UTF_8));
        String encrypted = Sha3Util.bytesToHex(sha3Bytes);
        usersRepository.changePassword(encrypted, id);
    }
}
