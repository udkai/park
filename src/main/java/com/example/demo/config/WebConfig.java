package com.example.demo.config;

import com.example.demo.intercepters.LoginIntercepter;
import com.example.demo.intercepters.UserLoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by liukai on 2018/7/24.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .excludePathPatterns("/login")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/logout")
                .addPathPatterns("/admin/*");
        registry.addInterceptor(new UserLoginIntercepter()).addPathPatterns("/user/*")
                .addPathPatterns("/message/*")
                .addPathPatterns("/car/*");
    }
}
