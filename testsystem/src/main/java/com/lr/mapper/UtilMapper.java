package com.lr.mapper;


import com.lr.util.subjectUtil;
import com.lr.util.testPaperUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UtilMapper {
    @Select("select t.id,t.testpaper_id testpaperId,t.subject_type subjectId,s.subjectType subjectName,score,t.subject_num num,t.state from testpaper t left\n" +
            "JOIN subject_type s on t.subject_type=s.subjectId HAVING t.testpaper_id=#{testPaperId}")
    List<testPaperUtil> paperMange(@Param("testPaperId") String testPaperId);

   List<subjectUtil> addTestPaper();

}
