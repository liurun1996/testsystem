package com.lr;

import com.lr.mapper.QuestionMapper;
import com.lr.mapper.UserMapper;
import com.lr.pojo.Question;
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
    UserMapper userMapper;
@Autowired
    QuestionMapper qq;

    @Test
    public void contextLoads() {
        List<Question> questions = qq.testgetALL();
        System.out.println(questions);
    }
}
