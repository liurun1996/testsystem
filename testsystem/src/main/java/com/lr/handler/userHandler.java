package com.lr.handler;

import com.alibaba.druid.sql.visitor.functions.If;
import com.lr.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class userHandler implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request, HttpSession session, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer URL = request.getRequestURL();
        String substring = URL.substring(URL.lastIndexOf("/") + 1);
        User user = (User) session.getAttribute("user");
        if (user!=null || "login.action".equals(substring)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
