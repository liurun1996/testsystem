package com.lr.mapper;

import com.lr.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface adminMapper{
//  @Select("select * from admin where admin_username=#{username} and admin_password=#{password}")
    Admin login(Admin admin);
}
