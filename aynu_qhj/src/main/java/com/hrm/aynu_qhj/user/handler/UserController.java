package com.hrm.aynu_qhj.user.handler;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrm.aynu_qhj.beans.UserInf;
import com.hrm.aynu_qhj.user.service.UserService;
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
    public String login(UserInf user, Model model, HttpServletRequest request) {
        UserInf u = userService.findUserByLoginUser(user);
        if (u == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        } else {
            request.getSession().setAttribute("user", u);
            model.addAttribute("user", u);
        }
        return "html/main";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/index.html";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "html/user/showAddUser";

    }

    @RequestMapping("/findUser")
    public String findUser(UserInf user, @RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageHelper.startPage(pageNum, 3);
        List<UserInf> userInfs = userService.findUser(user);
        model.addAttribute("userList", userInfs);
        PageInfo<UserInf> page = new PageInfo<UserInf>(userInfs);
        model.addAttribute("page", page);
        model.addAttribute("user", user);
        return "html/user/user";
    }

    @RequestMapping("/UpdateUser/{id}")
    public String UpdateUser(@PathVariable int id, Model model) {
        //根据id查询用户
        UserInf user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "html/user/showUpdateUser";

    }

    @RequestMapping("/removeUser")
    public String removeUser(Integer id[]) {
        System.out.println(id);
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
