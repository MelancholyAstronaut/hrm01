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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping("/login")
    public String verifyName(String loginname, String password, HttpServletRequest request) {
        Map user = new HashMap();
        user.put("name", loginname);
        user.put("password", password);

        UserInf u = userService.selectByNameAndPassword(user);
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
        return "redirect:../index.jsp";
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
}
