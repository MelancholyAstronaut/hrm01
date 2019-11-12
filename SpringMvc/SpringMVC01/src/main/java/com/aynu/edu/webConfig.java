package com.aynu.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.aynu.edu")
public class webConfig extends WebMvcConfigurerAdapter {
   @Bean
    public ViewResolver getViewResolver(){
       InternalResourceViewResolver irv = new InternalResourceViewResolver();
       irv.setPrefix("/WEB-INF/pages/");
       irv.setSuffix(".jsp");
       irv.setExposeContextBeansAsAttributes(true);
       return irv;
   }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
