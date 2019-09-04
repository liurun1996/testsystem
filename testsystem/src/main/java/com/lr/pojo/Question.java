package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private static final long serialVersionUID = -3558743435334905129L;
    private Integer id;

    private Integer subjectid;

    private String question;

    private String answer;

    private Integer state;

}