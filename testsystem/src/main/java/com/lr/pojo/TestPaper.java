package com.lr.pojo;

import java.io.Serializable;

public class TestPaper {
    private static final long serialVersionUID = -3558785342343129L;
    private Integer id;
    private String testpaperId;

    private Integer subjectType;

    private Integer subjectNum;

    private Integer state;

    public TestPaper() {
    }

    public TestPaper(Integer id, String testpaperId, Integer subjectType, Integer subjectNum, Integer state) {
        this.id = id;
        this.testpaperId = testpaperId;
        this.subjectType = subjectType;
        this.subjectNum = subjectNum;
        this.state = state;
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

    public String getTestpaperId() {
        return testpaperId;
    }

    public void setTestpaperId(String testpaperId) {
        this.testpaperId = testpaperId;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TestPaper{" +
                "id=" + id +
                ", testpaperId='" + testpaperId + '\'' +
                ", subjectType=" + subjectType +
                ", subjectNum=" + subjectNum +
                ", state=" + state +
                '}';
    }
}