package com.lr.util;


import com.lr.pojo.Question;
import com.lr.pojo.TestPaper;
import com.lr.service.questionService;
import com.lr.service.testpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Service
public class RandomQuestionUtil{
    @Autowired
    private   testpaperService testpaperService;
    @Autowired
    private  questionService questionService;

    public  List<String> selectTest() {

        return testpaperService.getAllPaperId();
    }

    public  String choiceTest() {
        List<String> list = selectTest();
        int i = (int) (Math.random() * list.size());
        return list.get(i);
    }





    //拿出对应类型题目num个 随机不重复
    public  List<Question> RandomQuestion(List<Question> questions, Integer num) {
        Random r = new Random();
        List<Question> questionsPaper = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        while (hs.size() < num) {
            int i = r.nextInt(questions.size());
            if (hs.contains(i)) {
                continue;
            } else {
                hs.add(i);
            }
        }

        for (Integer h : hs){
            Question question = questions.get(h);
            questionsPaper.add(question);
        }
        return questionsPaper;
    }


    public  List<Question> getQuestion(String testPaperId) {
        List<TestPaper> testPaper = testpaperService.getTestPaperByPaperId(testPaperId);
        List<Question> questions = new ArrayList<>();
        for (int i=0;i<testPaper.size();i++){
            List<Question> paperAllBysubId = questionService.getPaperAllBysubId(testPaper.get(i).getSubjectType());
            List<Question> randomGetQuestions = RandomQuestion(paperAllBysubId, testPaper.get(i).getSubjectNum());
            for (int j=0;j<randomGetQuestions.size();j++){
                questions.add(randomGetQuestions.get(j));
        System.out.println(questions.size());
            }
        }
        return questions;

    }



}
