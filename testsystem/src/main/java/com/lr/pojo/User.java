package com.lr.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 3558783123784905129L;
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

    public User() {
    }

    public User(Integer id, String username, String password, String name, String testpaperid, Integer state, Integer level, String gender, String address, String tel, String education, String school, String speciality) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.testpaperid = testpaperid;
        this.state = state;
        this.level = level;
        this.gender = gender;
        this.address = address;
        this.tel = tel;
        this.education = education;
        this.school = school;
        this.speciality = speciality;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestpaperid() {
        return testpaperid;
    }

    public void setTestpaperid(String testpaperid) {
        this.testpaperid = testpaperid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", testpaperid='" + testpaperid + '\'' +
                ", state=" + state +
                ", level=" + level +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}