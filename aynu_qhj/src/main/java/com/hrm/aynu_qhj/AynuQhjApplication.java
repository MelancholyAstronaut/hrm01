package com.hrm.aynu_qhj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@MapperScan("com.hrm.aynu_qhj.*.dao")
@ServletComponentScan(basePackages = "com.hrm.aynu_qhj.config")
@SpringBootApplication
public class AynuQhjApplication {

    public static void main(String[] args) {
        SpringApplication.run(AynuQhjApplication.class, args);
    }
}
