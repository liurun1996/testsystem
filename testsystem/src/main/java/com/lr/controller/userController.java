package com.lr.controller;

import com.lr.mapper.ExaminationMapper;
import com.lr.pojo.Examination;
import com.lr.pojo.Question;
import com.lr.pojo.User;
import com.lr.service.examinationService;
import com.lr.service.subjectTypeService;
import com.lr.service.userService;
import com.lr.util.RandomQuestionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping ("/user")
public class userController{

    @Autowired
    private userService userService;


    @Autowired
    private examinationService examinationService;
    @Autowired
    private subjectTypeService subjectTypeService;
    @Autowired
    private RandomQuestionUtil rqu;

    @RequestMapping ("/login.action")
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        session.removeAttribute("username");
        session.removeAttribute("password");
        User user = userService.login(username, password);
        if (user.getState() == 0) {
            user.setState(1);
            user.setTestpaperid(rqu.choiceTest());
            System.out.println(user.getTestpaperid());
            userService.updateByPrimaryKey(user);
        }
        session.setAttribute("user", user);
        return "user/testMainPage";
    }

    @GetMapping ("/toExamOnline.action")
    public String toExamOnline(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getState() == (1)) {
            System.out.println(user.getTestpaperid());

            List<Question> question = rqu.getQuestion(user.getTestpaperid().trim());
            for (Question q : question){
                examinationService.insert(new Examination(user.getUsername(), user.getTestpaperid(), q.getSubjectid(), q.getQuestion(), q.getId(), subjectTypeService.selectSubjecttypeById(q.getSubjectid()).getScore(), q.getAnswer(), null, 0));

            }
        }

        return "user/ExamOnline";
    }

}
