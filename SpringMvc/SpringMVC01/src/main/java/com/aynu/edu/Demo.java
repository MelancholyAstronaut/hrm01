package com.aynu.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   //注入控制层代码
public class Demo {
    @RequestMapping(path = "hello")   //设置value
    public String sayHello() {
        return "success";   //直接回到"success.jsp"
    }

}