package com.lr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.mapper.QuestionMapper;
import com.lr.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "questions")
public class questionService {
    @Autowired
    private QuestionMapper questionMapper;


    public List<Question> getQuestion(Integer subjectid, Integer nowPage) {

        PageHelper.startPage(nowPage, 5);
        PageInfo<Question> q = new PageInfo<>(questionMapper.getQuestion(subjectid));

        return q.getList();
    }

    //获取subjectid类型的题目有多少页
    public Integer getCountQuestions(Integer subjectid) {
        PageHelper.startPage(1, 5);
        PageInfo<Question> q = new PageInfo<>(questionMapper.getQuestion(subjectid));
        return q.getPages();
    }

    //增加题目
    public void addQuestion(Question question) {
        questionMapper.addQuestion(question);
    }

    //题目作废
    public void questionInvalid(Integer[] arr) {
        questionMapper.questionInvalid(arr);
    }

    public List<Question> getQuestionByType(Integer type) {
        return questionMapper.getQuestionByType(type);
    }

    public List<Question> getPaperAllBysubId(Integer testPaperId) {

        return questionMapper.getQuestion(testPaperId);
    }


    public List<Question> testgetALL(Integer id) {
        return questionMapper.testgetALL();
    }
}
