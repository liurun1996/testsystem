package com.lr.mapper;

import com.lr.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    //    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

    List<User> getAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*@Select("select * from user where username=#{username}")*/
    User getUserDetailByUsername(@Param("username") String username);
}