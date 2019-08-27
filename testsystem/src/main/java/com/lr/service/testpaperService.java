package com.lr.service;

import com.lr.mapper.TestPaperMapper;
import com.lr.pojo.TestPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testpaperService{
    @Autowired
    private TestPaperMapper testPaperMapper;

    public List<TestPaper> getAllTestPaper() {
        return testPaperMapper.getAllTestPaper();
    }

    public void addPapers(List<TestPaper> papers) {
        testPaperMapper.addPapers(papers);
    }


    public List<String> getAllPaperId() {
        return testPaperMapper.getAllPaperId();
    }
    public List<TestPaper> getTestPaperByPaperId(String testpaperId){
        return testPaperMapper.getTestPaperByPaperId(testpaperId);

    }
}