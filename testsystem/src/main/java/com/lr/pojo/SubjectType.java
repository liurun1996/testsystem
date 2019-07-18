package com.lr.pojo;

import java.io.Serializable;

public class SubjectType implements Serializable {
    private static final long serialVersionUID = -3558783123234905129L;
    private Integer subjectid;

    private String subjecttype;

    private Integer score;

    private String remark;

    private Integer readtype;

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjecttype() {
        return subjecttype;
    }

    public void setSubjecttype(String subjecttype) {
        this.subjecttype = subjecttype == null ? null : subjecttype.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getReadtype() {
        return readtype;
    }

    public void setReadtype(Integer readtype) {
        this.readtype = readtype;
    }

    @Override
    public String toString() {
        return "SubjectType{" +
                "subjectid=" + subjectid +
                ", subjecttype='" + subjecttype + '\'' +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                ", readtype=" + readtype +
                '}';
    }
}