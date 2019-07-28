package com.lr.service;

import com.lr.mapper.adminMapper;
import com.lr.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "admins")
public class adminService {
    @Autowired
    private adminMapper adminMapper;


    @Cacheable(value = "admin",key = "#username")
    public Admin login(String username, String password) {
        return adminMapper.login(new Admin(null, username, password));
    }
}

