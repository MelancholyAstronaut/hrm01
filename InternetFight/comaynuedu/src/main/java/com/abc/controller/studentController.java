package com.abc.controller;

import com.abc.pojo.personallearn;
import com.abc.pojo.student;
import com.abc.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
@Controller
public class studentController {
    @Autowired
    private IStudentService studentService;

    /**
     *
     * @param userId student.id
     * @param username student.name
     * @param model model对象，到jsp
     * @return 账号密码输入错误返回首页
     */
    @RequestMapping("/login")
    public String studentLogin(int userId, String username, Model model) {
        student s = studentService.verify(userId);
        if (s.getName().equals(username)) {
            model.addAttribute("student",s);
            return "success";
        }
        else return "forward:/index.jsp";
    }

    /**
     *
     * @param adminclass 行政班级
     * @param model model对象，到jsp
     * @return 一个返回的jsp页面
     */
    @RequestMapping("queryAllStudents")
    public String studentsQuery(String adminclass,Model model){
        //System.out.println(adminclass);
        List<student> ls =  studentService.queryStudents(adminclass);
        model.addAttribute("studentList",ls);

        return "studentList";
    }
    @RequestMapping("queryStudent")
    public String queryStudent(String name,Model model){
        student student = studentService.queryStudent(name);
        model.addAttribute("student",student);
        return "success";
    }
    @RequestMapping("querypersonallearn")
    public String querypersonallearn(int id,Model model){
        personallearn personallearn = studentService.querypersonallearn(id);
        System.out.println(personallearn);
        model.addAttribute("personallearn",personallearn);
        return "queryid";
    }

}
