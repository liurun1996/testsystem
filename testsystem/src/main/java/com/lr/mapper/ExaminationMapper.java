package com.lr.mapper;

import com.lr.pojo.Examination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationMapper {
    int insert(Examination record);

    int insertSelective(Examination record);

    List<Examination> selectBypaperId(String paperId);

    List<String> getExaminationTestpaperNum();

}