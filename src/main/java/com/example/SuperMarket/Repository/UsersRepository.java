package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long>{
    
    
}
