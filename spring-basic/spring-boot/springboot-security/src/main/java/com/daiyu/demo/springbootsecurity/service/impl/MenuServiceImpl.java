package com.daiyu.demo.springbootsecurity.service.impl;

import com.daiyu.demo.springbootsecurity.bean.Menu;
import com.daiyu.demo.springbootsecurity.dao.MenuRepository;
import com.daiyu.demo.springbootsecurity.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuMapper;


    @Override
    public List<Menu> getMenusByUserId(Integer userId) {
        return menuMapper.getMenusByUserId(userId);
    }
}
