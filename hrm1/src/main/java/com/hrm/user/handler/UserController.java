package com.hrm.user.handler;

import com.hrm.commons.beans.UserInf;
import com.hrm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
        request.setAttribute("message", "qqwq");
        UserInf u = userService.selectByNameAndPassword(user);
        if (u == null) {
            return "redirect:../index.jsp";
        } else {
            request.getSession().setAttribute("name", loginname);
        }
        return "main";
    }
}
