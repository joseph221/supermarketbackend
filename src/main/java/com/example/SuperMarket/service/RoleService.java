package com.example.SuperMarket.service;

import java.util.List;

import com.example.SuperMarket.Repository.RoleRepository;
import com.example.SuperMarket.model.Roles;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class RoleService {

    public final RoleRepository roleRepository;

    public List<Roles> getAllroles(){
        return roleRepository.findAll();
    }

    public void addRole(Roles roles){
        roleRepository.save(roles);
    }

    public Roles getByd(long id){
        return roleRepository.findById(id).get();
    }

    public void editRole(Roles roles){
        roleRepository.save(roles);
    }

    public void delete(long id){
        roleRepository.deleteById(id);
    }
}
