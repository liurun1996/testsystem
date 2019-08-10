package com.lr;

import com.lr.mapper.QuestionMapper;
import com.lr.mapper.UserMapper;
import com.lr.pojo.Examination;
import com.lr.pojo.Question;
import com.lr.service.examinationService;
import com.lr.util.RandomQuestionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith (SpringRunner.class)
@SpringBootTest
public class TestsystemApplicationTests{
    @Autowired
    examinationService userMapper;
@Autowired
    QuestionMapper qq;

    @Test
    public void contextLoads() {
        List<Examination> testspaperByUsername = userMapper.getTestspaperByUsername("10001");
 System.out.println(userMapper.getAllPaper());
    }
}
