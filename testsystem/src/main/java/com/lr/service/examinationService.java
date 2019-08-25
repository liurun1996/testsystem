package com.lr.service;

import com.lr.mapper.ExaminationMapper;
import com.lr.pojo.Examination;
import com.lr.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig (cacheNames = "examination")
public class examinationService{
    @Autowired
    public ExaminationMapper examinationMapper;

    public List<Examination> selectByPaperId(String paperId) {
        return examinationMapper.selectBypaperId(paperId);
    }

    public List<String> getExaminationTestpaperNum() {
        return examinationMapper.getExaminationTestpaperNum();
    }

    public void insert(Examination e) {
        examinationMapper.insert(e);

    }

    //    @Cacheable(value = "testPaper",key = "#p0")
    public List<Examination> getTestspaperByUsername(String userName) {
        return examinationMapper.getTestspaperByUsername(userName);
    }

    public Examination getExaByUsernameAndQuestionId(String username, Integer questionId) {
        return examinationMapper.getExaByUsernameAndQuestionId(username, String.valueOf(questionId));
    }

    public void commitTestPaper(Examination examination) {
        examinationMapper.commitTestPaper(examination);
    }

    public List<Examination> getAllPaper() {
        return examinationMapper.getAllPaper();
    }
    public void readEnd(Examination e){
        examinationMapper.readEnd(e);
    }
}
