package com.lr.pojo;

import java.io.Serializable;

public class Question implements Serializable {
    private static final long serialVersionUID = -3558743435334905129L;
    private Integer id;

    private Long subjectid;

    private String question;

    private String answer;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subjectid=" + subjectid +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", state=" + state +
                '}';
    }
}