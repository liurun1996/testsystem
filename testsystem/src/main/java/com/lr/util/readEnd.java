package com.lr.util;

public class readEnd{
    private String username;
    private Integer questionId;
    private Integer score;

    public readEnd() {
    }

    public readEnd(String username, Integer questionId, Integer score) {
        this.username = username;
        this.questionId = questionId;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "readEnd{" +
                "username='" + username + '\'' +
                ", questionId=" + questionId +
                ", score=" + score +
                '}';
    }
}
