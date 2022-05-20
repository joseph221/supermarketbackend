package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long>{
    
}
