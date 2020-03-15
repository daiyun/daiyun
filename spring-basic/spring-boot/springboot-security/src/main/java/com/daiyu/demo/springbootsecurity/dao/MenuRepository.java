package com.daiyu.demo.springbootsecurity.dao;

import com.daiyu.demo.springbootsecurity.bean.Menu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, String>, JpaSpecificationExecutor {

    @Query(value = "SELECT " +
            "m.* " +
            "FROM " +
            "(SELECT * FROM user ) u " +
            "INNER JOIN ( SELECT * FROM user_role ) ur ON u.id = ur.user_id AND u.id=?1 " +
            "INNER JOIN ( SELECT * FROM role ) r ON r.id = ur.role_id " +
            "INNER JOIN ( SELECT * FROM role_menu ) rm ON rm.role_id = r.id " +
            "INNER JOIN ( SELECT * FROM menu ) m ON rm.menu_id = m.id", nativeQuery = true)
    List<Menu> getMenusByUserId(Integer userId);
}
