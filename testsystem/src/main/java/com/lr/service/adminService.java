package com.lr.service;

import com.lr.mapper.adminMapper;
import com.lr.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService{
    @Autowired
    private adminMapper adminMapper;

    public Admin login(String username, String password) {
        return adminMapper.login(new Admin(null,username,password));
    }
}

