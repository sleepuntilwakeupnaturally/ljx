package com.mydemo.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测全局session对象中是否有uid数据，如果有则放行，如果没有则重定向到登录
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(url + Controller： 映射)
     * @return 如果返回值为true表示放行当前请求，如果返回之为false这表示拦截
     *         当前请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //HttpServletRequest对象来获取session对象

        Object obj = request.getSession().getAttribute("id");
        if (obj == null){//说明用户没有登录系统，重定向
            response.sendRedirect("/web/login.html");
            //结束后续调用
            return false;
        }
        return true;
    }
}
