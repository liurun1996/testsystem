package com.lr.service;

import com.lr.mapper.SubjectTypeMapper;
import com.lr.pojo.SubjectType;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subjectTypeService {
    @Autowired
    private SubjectTypeMapper sub;

    public List<SubjectType> getAllsubjectType(String key) {
        return sub.getAllsubjectType();
    }

    public SubjectType selectSubjecttypeById(Integer id) {
        return sub.selectSubjecttypeById(id);
    }

    public int UpdateSubjcetType(SubjectType subjectType) {
        return sub.UpdateSubjcetType(subjectType);
    }

    public void insertSelective(SubjectType subjectType) {
        sub.insertSelective(subjectType);
    }

    public int deleteByPrimaryKeys(Integer[] arr) {
        return sub.deleteByPrimaryKeys(arr);
    }

    public Integer getScoreByType(Integer type) {
        return sub.getScoreByType(type);
    }

}
