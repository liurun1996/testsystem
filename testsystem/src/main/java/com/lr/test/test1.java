package com.lr.test;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(UserMapper.class)
 public class test1 {
    @Autowired
    UserMapper userMapper;


}
