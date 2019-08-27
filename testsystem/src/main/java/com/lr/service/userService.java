package com.lr.service;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService{
    @Autowired
    private UserMapper userMapper;


    public User login(String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        User user = userMapper.login(u);
        return user;

    }

    public User getUserDetailByUsername(String username) {
        return userMapper.getUserDetailByUsername(username);
    }

    public void updateByPrimaryKey(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public List<User> getAllUser() {

        return userMapper.getAllUser();
    }

    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    public void deleteUserById(Integer[] arr) {
        userMapper.deleteUserById(arr);
    }
    public  void addUser(User user){
        userMapper.addUser(user);
    }
}
