package com.mydemo.demo.config;


import com.mydemo.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理拦截器的注册
 */
@Configuration//加载当前拦截器并进行调用
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    /**
     *配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单，存放在List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/web/Addorder.html");
        patterns.add("/web/administrator.html");
        patterns.add("/web/Adpage.html");
        patterns.add("/web/allorder.html");
        patterns.add("/web/userorder.html");
      

        //拦截器的注册
        registry.addInterceptor(interceptor).addPathPatterns(patterns);//表示要拦截的url是什么
    }
}

