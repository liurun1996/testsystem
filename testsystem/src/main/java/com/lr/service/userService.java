package com.lr.service;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class userService{
    @Autowired
    private UserMapper userMapper;


    @CachePut(value = "user",key = "#p0")
    public User login(String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        User user = userMapper.login(u);
        return user;

    }

    public User getUserDetailById(String username) {
        return userMapper.getUserDetailByUsername(username);
    }

    public void updateByPrimaryKey(User user) {
        userMapper.updateByPrimaryKey(user);
    }
}
