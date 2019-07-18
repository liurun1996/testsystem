package com.lr.util;

import java.io.Serializable;

public class testPaperUtil implements Serializable {
    private static final long serialVersionUID = -35583434405129L;
    private Integer id;
    private String testpaperId;
    private Integer subjectId;
    private String  subjectName;
    private Integer score;
    private Integer num;
    private Integer state;
    public testPaperUtil() {

    }
    public testPaperUtil(Integer id, String testpaperId, Integer subjectId, String subjectName, Integer sore, Integer num, Integer state) {
        this.id = id;
        this.testpaperId = testpaperId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.score = sore;
        this.num = num;
        this.state = state;
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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSore() {
        return score;
    }

    public void setSore(Integer sore) {
        this.score = sore;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "testPaperUtil{" +
                "id=" + id +
                ", testpaperId='" + testpaperId + '\'' +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", score=" + score +
                ", num=" + num +
                ", state=" + state +
                '}';
    }
}
