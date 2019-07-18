package com.lr.service;

import com.lr.mapper.SubjectTypeMapper;
import com.lr.pojo.SubjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subjectTypeService {
    @Autowired
    private SubjectTypeMapper sub;

    @Cacheable(value = "allSubject#1000#2")
    public List<SubjectType> getAllsubjectType() {
        return sub.getAllsubjectType();
    }

    @Cacheable(value = "subJById#1000#1",sync = true)
    public SubjectType selectSubjecttypeById(Integer id) {
        return sub.selectSubjecttypeById(id);
    }

    public int UpdateSubjcetType(SubjectType subjectType) {
        return sub.UpdateSubjcetType(subjectType);
    }

    public void insertSelective(SubjectType subjectType) {
         sub.insertSelective(subjectType);
    }

    public int deleteByPrimaryKeys(Integer [] arr){
        return sub.deleteByPrimaryKeys(arr);
    }

}
