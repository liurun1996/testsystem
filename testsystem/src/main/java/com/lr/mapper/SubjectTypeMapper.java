package com.lr.mapper;

import com.lr.pojo.SubjectType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SubjectTypeMapper {
    int deleteByPrimaryKey(Integer subjectid);

    @Select("select * from subject_type")
    List<SubjectType> getAllsubjectType();

    @Select("select * from subject_type where subjectId=#{id} ")
    SubjectType selectSubjecttypeById(@Param("id") Integer id);

    int insert(SubjectType record);

    void insertSelective(SubjectType record);

    SubjectType selectByPrimaryKey(Integer subjectid);

    int updateByPrimaryKeySelective(SubjectType record);

    int UpdateSubjcetType(SubjectType subjectType);

    int deleteByPrimaryKeys(Integer[] arr);

}