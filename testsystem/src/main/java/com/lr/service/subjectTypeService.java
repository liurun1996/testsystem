package com.lr.service;

import com.lr.mapper.SubjectTypeMapper;
import com.lr.pojo.SubjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "subjectType")
public class subjectTypeService {
    @Autowired
    private SubjectTypeMapper sub;

    @Cacheable(value = "allSubject")
    public List<SubjectType> getAllsubjectType(String key) {
        return sub.getAllsubjectType();
    }

    //    @Cacheable(value = "subJById#1000#1",key = "#id",sync = true)
    @CachePut(key = "#id")
    public SubjectType selectSubjecttypeById(Integer id) {
        return sub.selectSubjecttypeById(id);
    }

    @CachePut(value = "allSubject",key = "#subjectType.subjectid")
    public int UpdateSubjcetType(SubjectType subjectType) {
        return sub.UpdateSubjcetType(subjectType);
    }

    @CachePut(key = "#subjectType.subjectid")
    public void insertSelective(SubjectType subjectType) {
        sub.insertSelective(subjectType);
    }

    @CacheEvict(key = "#arr")
    public int deleteByPrimaryKeys(Integer[] arr) {
        return sub.deleteByPrimaryKeys(arr);
    }

}
