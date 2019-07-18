package com.lr.service;

import com.lr.mapper.ExaminationMapper;
import com.lr.pojo.Examination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class examinationService {
    @Autowired
  private ExaminationMapper examinationMapper;

    public List<Examination> selectByPaperId(String paperId){
        return examinationMapper.selectBypaperId(paperId);
    }
    public List<String> getExaminationTestpaperNum(){
        return examinationMapper.getExaminationTestpaperNum();
    }
}
