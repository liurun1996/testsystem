package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String testpaperid;
    private Integer state;
    private Integer level;
    private String gender;
    private String address;
    private String tel;
    private String education;
    private String school;
    private String speciality;

}