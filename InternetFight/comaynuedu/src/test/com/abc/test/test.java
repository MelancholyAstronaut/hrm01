package com.abc.test;

import com.abc.services.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test{
    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService studentService = (IStudentService) applicationContext.getBean("studentService");
        // var a = studentService.verify(1);
        // System.out.println(a);

        var a =studentService.queryStudents("17java1");
        a.forEach(e-> System.out.println(e));

    }
}