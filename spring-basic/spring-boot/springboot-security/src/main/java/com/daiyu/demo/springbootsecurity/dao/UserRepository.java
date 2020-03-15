package com.daiyu.demo.springbootsecurity.dao;

import com.daiyu.demo.springbootsecurity.bean.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String>, JpaSpecificationExecutor {

    @Query(value = "select * from user where username=?1 and password=?2", nativeQuery = true)
    User getUserInfo(String username, String pwd);

    @Query(value = "select * from user where username=?1", nativeQuery = true)
    User loadUserByUsername(String s);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAllUsers();
}
