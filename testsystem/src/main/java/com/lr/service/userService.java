package com.lr.service;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private UserMapper userMapper;


    @Cacheable(value = "user#1000#10")
    public User login(String username, String password) {
        return userMapper.login(username, password);

    }
}
