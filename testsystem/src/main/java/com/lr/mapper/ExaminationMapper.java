package com.lr.mapper;

import com.lr.pojo.Examination;
import com.lr.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationMapper{
    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectBypaperId(String paperId);

    List<String> getExaminationTestpaperNum();

    List<Examination> getTestspaperByUsername(@Param ("userName") String userName);

    Examination getExaByUsernameAndQuestionId(@Param ("username") String username, @Param ("questionId") String  questionId);

    void commitTestPaper(Examination examination);
}