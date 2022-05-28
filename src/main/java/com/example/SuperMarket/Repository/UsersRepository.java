package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Long>{
    
    @Query(value = "select * from users where username=?1 and password=?2",nativeQuery = true)
    public Users getLogins(String username,String password);
}
