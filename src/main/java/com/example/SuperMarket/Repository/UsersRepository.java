package com.example.SuperMarket.Repository;

import com.example.SuperMarket.model.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepository extends JpaRepository<Users,Long>{
    
    @Query(value = "select * from users where username=?1 and password=?2",nativeQuery = true)
    public Users getLogins(String username,String password);

    @Query(value = "select * from users",nativeQuery = true)
    public List<Users> isUser();

    @Transactional
    @Modifying
    @Query(value = "update users set password=?1 where id =?2",nativeQuery = true)
    public void changePassword(String newpass,long id);

    @Query(value = "select * from users where password=?",nativeQuery = true)
    public Users CurrentPassword(String currentpass);
}
