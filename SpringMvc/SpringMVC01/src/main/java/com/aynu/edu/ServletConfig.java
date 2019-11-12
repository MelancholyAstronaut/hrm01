package com.aynu.edu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc

@Configuration
@ComponentScan(basePackages = {"com.aynu.edu"},
    excludeFilters = {
        @Filter(type=FilterType.ANNOTATION,value = EnableWebMvc.class)
    }
)
public class ServletConfig {
}
