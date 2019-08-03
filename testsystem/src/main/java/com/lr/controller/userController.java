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
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    //如果时第一次登录那么将随机分配一张以存在的试卷，且把状态改为1
    @RequestMapping ("/login.action")
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        session.removeAttribute("username");
        session.removeAttribute("password");
        User user = userService.login(username, password);
        if (user.getState().equals(0)) {
            user.setState(1);
            user.setTestpaperid(rqu.choiceTest());
            userService.updateByPrimaryKey(user);
        }
        session.setAttribute("user", user);
        return "user/testMainPage";
    }

    //如果状态为1，则随机出题
    @GetMapping ("/toExamOnline.action")
    public String toExamOnline(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user.getState().equals(1)) {
            List<Question> question = rqu.getQuestion(user.getTestpaperid().trim());
            for (Question q : question){
                examinationService.insert(new Examination(user.getUsername(), user.getTestpaperid(), q.getSubjectid(), q.getQuestion(), q.getId(), subjectTypeService.selectSubjecttypeById(q.getSubjectid()).getScore(), q.getAnswer(), null, 0));
            }
            user.setState(2);
            userService.updateByPrimaryKey(user);
        }
        request.setAttribute("testpaperid", user.getTestpaperid());
        return "user/ExamOnline";
    }

    @GetMapping ("/toTestPage.action")
    public ModelAndView toTestPage(ModelAndView mv, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Examination> testPaper = examinationService.getTestspaperByUsername(user.getUsername());
        List<Examination> AchoiceQuestion = new ArrayList<>();//单选题
        List<Examination> DchoiceQuestion = new ArrayList<>();//多选题
        List<Examination> TrueOrFalse = new ArrayList<>();//判断题
        List<Examination> shortAnswer = new ArrayList<>();//简答题题
        List<Examination> BCT = new ArrayList<>();//简答题题

        for (Examination e : testPaper){
            if (e.getSubjectId().equals(1)) {
                AchoiceQuestion.add(e);
            } else if (e.getSubjectId().equals(2)) {
                DchoiceQuestion.add(e);
            } else if (e.getSubjectId().equals(3)) {
                TrueOrFalse.add(e);
            } else if (e.getSubjectId().equals(4)) {
                shortAnswer.add(e);
            } else {
                BCT.add(e);
            }
        }
        mv.addObject("AchoiceQuestion",AchoiceQuestion);
        mv.addObject("DchoiceQuestion",DchoiceQuestion);
        mv.addObject("TrueOrFalse",TrueOrFalse);
        mv.addObject("shortAnswer",shortAnswer);
        mv.addObject("BCT",BCT);
        mv.setViewName("user/CreateTheme");
        return mv;
    }
}
