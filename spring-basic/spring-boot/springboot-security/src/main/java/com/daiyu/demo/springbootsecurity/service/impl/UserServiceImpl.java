package com.daiyu.demo.springbootsecurity.service.impl;

import com.daiyu.demo.springbootsecurity.bean.User;
import com.daiyu.demo.springbootsecurity.dao.UserRepository;
import com.daiyu.demo.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userMapper;

    @Override
    public User getUserInfo(User user) {
        User userInfo = userMapper.getUserInfo(user.getUsername(), user.getPassword());
        return userInfo;
    }

    @Override
    public User loadUserByUsername(String s) {
        return userMapper.loadUserByUsername(s);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
