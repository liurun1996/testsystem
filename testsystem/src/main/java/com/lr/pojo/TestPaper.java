package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPaper {
    private static final long serialVersionUID = -3558785342343129L;
    private Integer id;
    private String testpaperId;

    private Integer subjectType;

    private Integer subjectNum;

    private Integer state;

}