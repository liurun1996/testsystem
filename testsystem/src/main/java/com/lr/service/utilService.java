package com.lr.service;

import com.lr.mapper.UtilMapper;
import com.lr.util.subjectUtil;
import com.lr.util.testPaperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class utilService {
    @Autowired
    private UtilMapper utilMapper;

    @Cacheable(value = "testpaper")
    public List<testPaperUtil> paperMange(String testPaperId) {
        return utilMapper.paperMange(testPaperId);
    }

    @Cacheable(value = "addTestPaperUtil")
    public List<subjectUtil> addTestPaper() {

        return utilMapper.addTestPaper();
    }
}
