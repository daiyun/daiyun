package com.daiyu.demo.springbootsecurity.service;

import com.daiyu.demo.springbootsecurity.bean.Menu;

import java.util.List;


public interface MenuService {

    List<Menu> getMenusByUserId(Integer userId);
}
