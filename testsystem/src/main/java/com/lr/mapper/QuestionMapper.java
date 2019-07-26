package com.lr.mapper;

import com.lr.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CachePut;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    List<Question> getQuestion(@Param("subjectId") Integer subjectId);

    int addQuestion(Question record);

    void questionInvalid(Integer[] arr);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    List<Question> testgetALL();

    int updateByPrimaryKey(Question record);

    List<Question> getQuestionByType(Integer type);
}