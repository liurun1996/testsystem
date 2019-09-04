package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectType {
    private static final long serialVersionUID = -3558783123234905129L;
    private Integer subjectid;

    private String subjecttype;

    private Integer score;

    private String remark;

    private Integer readtype;

}