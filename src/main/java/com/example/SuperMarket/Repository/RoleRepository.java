package com.example.SuperMarket.Repository;

import java.util.List;

import com.example.SuperMarket.model.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long>{

    public List<Roles> getByRoleId(long role_id);
    
}
