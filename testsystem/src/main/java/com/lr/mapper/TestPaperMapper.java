package com.lr.mapper;

import com.lr.pojo.TestPaper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestPaperMapper {
    int insert(TestPaper record);

    void addPapers(List<TestPaper> papers);

    List<String> getAllPaperId();

    List<TestPaper> getAllTestPaper();

    int insertSelective(TestPaper record);
}