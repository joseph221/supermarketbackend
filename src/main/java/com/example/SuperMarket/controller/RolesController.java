package com.example.SuperMarket.controller;

import java.util.List;

import com.example.SuperMarket.Api.RoleApi;
import com.example.SuperMarket.model.Roles;
import com.example.SuperMarket.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RolesController implements RoleApi{
    @Autowired
    private RoleService roleService;
    @Override
    public List<Roles> getRoles() {
        return roleService.getAllroles();
    }

    @Override
    public void add(Roles roles) {
        roleService.addRole(roles);
    }

    @Override
    public Roles getByRoleId(long rid) {
        return roleService.getByd(rid);
    }

    @Override
    public void editRole(Roles roles) {
        roleService.editRole(roles);
        
    }

    @Override
    public void delete(long id) {
      roleService.delete(id);
        
    }
    
}
