package com.lr.pojo;

public class Examination {
    private String examineeId;

    private String testpaperId;

    private Long subjectId;

    private String questionContent;

    private Long questionId;

    private Integer questionScore;

    private String correctAnswer;

    private String examineeAnswer;


    private Integer score;

    public Examination() {
    }

    public String getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(String examineeId) {
        this.examineeId = examineeId;
    }

    public String getTestpaperId() {
        return testpaperId;
    }

    public void setTestpaperId(String testpaperId) {
        this.testpaperId = testpaperId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Integer questionScore) {
        this.questionScore = questionScore;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExamineeAnswer() {
        return examineeAnswer;
    }

    public void setExamineeAnswer(String examineeAnswer) {
        this.examineeAnswer = examineeAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "examineeId='" + examineeId + '\'' +
                ", testpaperId='" + testpaperId + '\'' +
                ", subjectId=" + subjectId +
                ", questionContent='" + questionContent + '\'' +
                ", questionId=" + questionId +
                ", questionScore=" + questionScore +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", examineeAnswer='" + examineeAnswer + '\'' +
                ", score=" + score +
                '}';
    }
}