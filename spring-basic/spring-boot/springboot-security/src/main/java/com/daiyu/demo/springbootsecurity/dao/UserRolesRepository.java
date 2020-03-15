package com.daiyu.demo.springbootsecurity.dao;

import com.daiyu.demo.springbootsecurity.bean.UserRoles;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRolesRepository extends CrudRepository<UserRoles, String>, JpaSpecificationExecutor {
    @Select("select user_id,role_id from user_roles where user_id = #{userId}")
    @Results(value = {@Result(property = "userId", column = "user_id"),
            @Result(property = "roleId", column = "role_id"),
    })
    @Query(value = "select user_id,role_id from user_roles where user_id =?1", nativeQuery = true)
    List<UserRoles> getRolesBeanById(String userId);
}
