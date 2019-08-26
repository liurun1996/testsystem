package com.lr.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lr.pojo.*;
import com.lr.service.*;
import com.lr.util.readEnd;
import com.lr.util.subjectUtil;
import com.lr.util.testPaperUtil;
import com.lr.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/admin")
public class ManagerController{
    @Autowired
    private userService userService;
    @Autowired
    private subjectTypeService subjectTypeService;
    @Autowired
    private questionService questionService;
    @Autowired
    private utilService utilService;
    @Autowired
    private testpaperService testpaperService;
    @Autowired
    private subjectTypeService subService;
    @Autowired
    examinationService examinationService;
    @Autowired
    private adminService adminService;

    @RequestMapping ("/index.action")
    public String index() {
        return "login";
    }

    @GetMapping ("/toMain.action")
    public String toMain() {
        return "Manage";
    }

    @RequestMapping ("/login.action")
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        session.removeAttribute("username");
        session.removeAttribute("password");
        System.out.println(username);
        System.out.println(password);

        Admin admin = adminService.login(username, password);
        System.out.println(admin);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "Manage";
        }else {
            return "redirect:/index.action";
        }
    }

    @GetMapping ("/toThemeSortManage.action")
    public String toThemeSortManage(ModelAndView mv, HttpServletRequest request) {
        List<SubjectType> allsubjectType = subjectTypeService.getAllsubjectType("ThemeSortManage");
        request.setAttribute("allSubject", allsubjectType);
        return "ThemeSortManage";
    }

    @RequestMapping ("/toThemeSortUpdate.action")
    public String toThemeSortUpdate(Integer subjectid, HttpServletRequest request) {
        SubjectType subjectType = subjectTypeService.selectSubjecttypeById(subjectid);
        request.setAttribute("subjectType", subjectType);
        return "ThemeSortUpdate";
    }


    @PostMapping ("/doThemeSortUpdate.action")
    public String doThemeSortUpdate(SubjectType subjectType) {
        subjectTypeService.UpdateSubjcetType(subjectType);

        return "redirect:/admin/toThemeSortManage.action";
    }

    @GetMapping ("/toThemeSortInsert.action")
    public String toThemeSortInsert() {
        return "ThemeSortInsert";
    }

    @PostMapping ("/ThemeSortInsert.action")
    public String ThemeSortInsert(SubjectType subjectType) {
        subjectTypeService.insertSelective(subjectType);

        return "redirect:/admin/toThemeSortManage.action";
    }

    @RequestMapping ("/subjectDel.action")
    public void subjectDel(Integer[] arr, HttpServletResponse response) {
        subjectTypeService.deleteByPrimaryKeys(arr);
        try {
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping ("/toThemesManage.action")
    public ModelAndView toThemesManage(ModelAndView mv, Integer subjectTypeId, Integer nowPage) {
        if (nowPage == null) {
            nowPage = 1;
        }
        if (subjectTypeId == null) {
            subjectTypeId = 1;
        }

        Integer countQuestions = questionService.getCountQuestions(subjectTypeId);
        List<Question> question = questionService.getQuestion(subjectTypeId, nowPage);
        List<SubjectType> allsubjectType = util.sort(subjectTypeId, subjectTypeService.getAllsubjectType("ThemesManage"));
        Integer nowSubjectTypeId = subjectTypeId;
        mv.addObject("nowSubjectTypeId", nowSubjectTypeId);
        mv.addObject("allsubjectType", allsubjectType);
        mv.addObject("nowPage", nowPage);
        mv.addObject("countQuestions", countQuestions);
        mv.addObject("question", question);
        mv.setViewName("ThemesManage");
        return mv;
    }

    @PostMapping ("/SubTypeChange.action")
    public void SubTypeChange(Integer subjectTypeId, HttpServletResponse response, HttpServletRequest request) {
        Integer countQuestions = questionService.getCountQuestions(subjectTypeId);
//        List<SubjectType> allsubjectType = util.sort(subjectTypeId, subjectTypeService.getAllsubjectType());
        List<Question> question = questionService.getQuestion(subjectTypeId, 1);
        String json = JSONArray.toJSONString(question);
        try {
            response.setContentType("application/json,charsetutf-8");
            response.getWriter().write(json);
            request.setAttribute("nowSubjectTypeId", subjectTypeId);
            request.setAttribute("countQuestions", countQuestions);
            request.setAttribute("nowPage", 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping ("/toThemeInsert.action")
    public ModelAndView toThemeInsert(ModelAndView mv, Integer subjectid) {
        if (subjectid == null) {
            subjectid = 1;
        }

        List<SubjectType> allsubjectType = util.sort(subjectid, subjectTypeService.getAllsubjectType("ThemeInsert"));
        String remark = allsubjectType.get(0).getRemark();
        mv.addObject("remark", remark);
        mv.addObject("allsubjectType", allsubjectType);
        mv.setViewName("ThemeInsert");
        return mv;
    }

    @PostMapping ("/addQuestion.action")
    public String addQuestion(Question question) {
        question.setId(0);
        question.setState(0);
        questionService.addQuestion(question);
        return "redirect:/admin/toThemeInsert.action?subjectid=" + question.getSubjectid();
    }

    @PostMapping ("/toInvalid.action")
    public void toInvalid(Integer[] arr, HttpServletResponse response) {
        questionService.questionInvalid(arr);
        try {
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping ("/toTestPaperManage.action")
    public String toTestPaperManage(String testPaperId/*试卷编号*/, HttpServletRequest request) {
        List<TestPaper> allTestPaper = testpaperService.getAllTestPaper();
        request.setAttribute("allTestPaper", allTestPaper);
        if (!"".equals(testPaperId) && testPaperId != null) {
            List<testPaperUtil> testpaper = utilService.paperMange(testPaperId);
            String testpaperId = testpaper.get(0).getTestpaperId();
            request.setAttribute("testpaperId", testPaperId);
            request.setAttribute("testpaper", testpaper);
        }

        return "TestPaperManage";
    }

    @GetMapping ("/toTestPaperOrder.action")
    public String toTestPaperOrder(HttpServletRequest request) {
        List<subjectUtil> allsubjectType = utilService.addTestPaper();
        request.setAttribute("allsubjectType", allsubjectType);

        return "TestPaperOrder";
    }

    @PostMapping ("/randomTestPaperId.action")
    public void randomTestPaperID(HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> allPaperId = testpaperService.getAllPaperId();
        String paperId = util.getPaperId();
        while (allPaperId.contains(paperId)) {
            paperId = util.getPaperId();
        }
        pw.write(paperId);


    }


    @PostMapping ("addTestPaper.action")
    public void addTestPaper(HttpServletResponse response, String[] typeAndNum, String paperId) {
        List<TestPaper> testPapers = new ArrayList<TestPaper>();
        for (String str : typeAndNum){
            String[] split = str.split(":");
            if (!"".equals(split[0]) && !"".equals(split[1]) && !"a".equals(split[0]) && !"b".equals(split[1])) {
                if (!"0".equals(split[1])) {
                    TestPaper t = new TestPaper(0, paperId, Integer.parseInt(split[0]), Integer.parseInt(split[1]), 0);
                    testPapers.add(t);
                }
            }
        }
        testpaperService.addPapers(testPapers);
        try {
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping ("/toExamManage.action")
    public ModelAndView toExamManagePaperIdSelect(ModelAndView mv) {
        List<String> examinationAllTestPaper = examinationService.getExaminationTestpaperNum();
        mv.addObject("allPaperId", examinationAllTestPaper);
        mv.setViewName("ExamManage");
        return mv;
    }


    @PostMapping ("/selectByPaperId.action")
    public void selectByPaperID(String paperId, HttpServletResponse response) {
        List<Examination> examinations = examinationService.selectByPaperId(paperId);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(examinations));
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping ("/userDetail.action")
    public @ResponseBody
    User userDetail(String username) {
        User userDetailById = userService.getUserDetailByUsername(username);
        return userDetailById;
    }

    @GetMapping ("/toReadPaper.action")
    public ModelAndView toReadPaper(ModelAndView mv) {
        List<User> allUser = userService.getAllUser();
        Integer state = 3;
        for (int i = 0 ; i < allUser.size() ; i++){
            User u = allUser.get(i);
            if (!state.equals(u.getState())) {
                allUser.remove(i);
            }

        }
        if (allUser.size() > 0) {
            mv.addObject("allUser", allUser);
        }
        mv.setViewName("ReadPaper");
        return mv;
    }

    @RequestMapping (value = "/selectPaper.action", method = RequestMethod.POST)
    public void selectPaper(String username, HttpServletResponse response) {
        List<Examination> examinations = examinationService.getTestspaperByUsername(username);
        List<Examination> needRead = new ArrayList<>();
        for (Examination e : examinations){
            if (subjectTypeService.selectSubjecttypeById(e.getSubjectId()).getReadtype() == 1) {
                needRead.add(e);
            }
        }
        String json = JSONArray.toJSONString(needRead);
        try {
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping ("/readEnd.action")
    public void readEnd(String json, HttpServletResponse response) {
        List<readEnd> readEnds = JSON.parseArray(json, readEnd.class);
        List<Examination> examinations = util.readPaperCast(readEnds);
        for (Examination e : examinations){
            examinationService.readEnd(e);
        }
        User user = userService.getUserDetailByUsername(examinations.get(0).getUserName());
        user.setState(4);
        userService.updateByPrimaryKey(user);
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().println("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping ("/userManage.action")
    public ModelAndView userManage(ModelAndView mv) {
        List<User> users = userService.getAllUser();
        mv.addObject("users", users);
        mv.setViewName("Employee");

        return mv;
    }

    @GetMapping ("/updateUser.action")
    public ModelAndView updateUser(Integer userId, ModelAndView mv) {
        User user = userService.getUserById(userId);
        mv.addObject("user", user);
        mv.setViewName("UpdateEmployee");
        return mv;
    }

    @PostMapping ("/doUserUpdate.action")
    @Transactional (rollbackFor = Exception.class)
    public String doUserUpdate(User user) {
        User user1 = userService.getUserById(user.getId());
        Integer state = 0;
        if (user.getState() != user1.getState() && state.equals(user.getState())) {
            user1.setTestpaperid("");
            userService.updateByPrimaryKey(user1);

        }
        examinationService.delByUsername(user1.getUsername());
        return "redirect:/userManage.action";
    }

    @PostMapping ("/deletUser.action")
    @Transactional (rollbackFor = Exception.class)
    public @ResponseBody
    String deletUser(Integer[] arr) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : arr){
            User userById = userService.getUserById(i);
            examinationService.delByUsername(userById.getUsername());
        }
        userService.deleteUserById(arr);
        System.out.println(list);
        return "1";
    }

    @RequestMapping ("/toAddUser.action")
    public String toAddUser() {
        return "AddEmployee";
    }
    @PostMapping("/AddUser.action")
    public String AddUser(User user){
        user.setState(0);
        userService.addUser(user);
        System.out.println(user);
        return "redirect:/userManage.action";
    }
}
