package com.lr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examination {
    private String userName;

    private String testpaperId;

    private Integer subjectId;

    private String questionContent;

    private Integer questionId;

    private Integer questionScore;

    private String correctAnswer;

    private String userAnswer;


    private Integer score;


}