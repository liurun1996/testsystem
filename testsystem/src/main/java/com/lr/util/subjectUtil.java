package com.lr.util;

import com.lr.pojo.SubjectType;

import java.io.Serializable;

public class subjectUtil implements Serializable {
    private static final long serialVersionUID = -35583433425129L;
    private SubjectType subjectType;
    private Integer subjectNum;

    public subjectUtil() {
    }

    public subjectUtil(SubjectType subjectType, Integer subjectNum) {
        this.subjectType = subjectType;
        this.subjectNum = subjectNum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    @Override
    public String toString() {
        return "subjectUtil{" +
                "subjectType=" + subjectType +
                ", subjectNum=" + subjectNum +
                '}';
    }
}