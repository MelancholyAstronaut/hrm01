package com.hrm.user.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.commons.beans.UserInf;
import com.hrm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping("/login")
    public String login(UserInf user, HttpServletRequest request) {
        //  System.out.println(user);
        UserInf u = userService.findUserByLoginUser(user);
        //  System.out.println(u);
        if (u == null) {
            request.setAttribute("message", "用户名或者密码错误");
            return "../index";
        } else {
            request.getSession().setAttribute("user", u);
        }
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:../index";
    }

    @RequestMapping("/findUser")
    public String findUser(UserInf user, @RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageHelper.startPage(pageNum, 3);
        List<UserInf> userInfs = userService.findUser(user);
        model.addAttribute("userList", userInfs);
        PageInfo<UserInf> page = new PageInfo<UserInf>(userInfs);
        model.addAttribute("page", page);
        model.addAttribute("user", user);
        return "user/user";
    }

    @RequestMapping("/UpdateUser/{id}")
    public String UpdateUser(@PathVariable int id, Model model) {
        //根据id查询用户
        UserInf user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/showUpdateUser";

    }

    @RequestMapping("/removeUser/{id}")
    public String removeUser(@PathVariable Integer id) {
        // System.out.println("即将删除的id =>>>>>>>>>" + id);
        userService.removeUser(id);
        return "redirect:/user/findUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(UserInf user) {
        //System.out.println(user);
        //UserInf(id=2, loginname=qiu, password=123456, status=1, createdate=null, username=邱一)
        userService.modifyUser(user);
        return "redirect:/user/findUser";
    }

    @RequestMapping("/addUser")
    public String addUser(UserInf user) {
        userService.addUser(user);
        return "redirect:/user/findUser";
    }

}
