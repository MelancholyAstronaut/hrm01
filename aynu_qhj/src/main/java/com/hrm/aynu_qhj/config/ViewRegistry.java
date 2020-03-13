package com.hrm.aynu_qhj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewRegistry implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/templates/html/top.html").setViewName("html/top");
        registry.addViewController("/templates/html/left.html").setViewName("html/left");
        registry.addViewController("/templates/html/right.html").setViewName("html/right");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html","/index","/user/login","/css/**","/images/**","/js/**","**.ico");

    }


}
