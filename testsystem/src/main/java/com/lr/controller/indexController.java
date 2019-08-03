package com.lr.controller;

import com.lr.mapper.QuestionMapper;
import com.lr.pojo.Admin;
import com.lr.pojo.Question;
import com.lr.pojo.User;
import com.lr.service.adminService;
import com.lr.service.questionService;
import com.lr.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class indexController{
    @Autowired
    private userService userService;
    @Autowired
    private adminService adminService;


    @RequestMapping (value = "/index.action")
    public String index(HttpServletRequest request, String msg) {
        request.setAttribute("msg", msg);
        return "login";
    }

    @PostMapping ("/login.action")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "redirect:/admin/login.action";
        } else if (user != null) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "redirect:/user/login.action";
        } else {
         return "redirect:/index.action?msg=账号或密码错误";
        }
    }

}
