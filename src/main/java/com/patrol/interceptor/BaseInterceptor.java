package com.patrol.interceptor;

import com.patrol.common.Constants;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 基础拦截器
 *
 * @author WangSheng/2019-05-18
 */
public class BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        request.setAttribute("webUrl", Constants.webUrl);
        request.setAttribute("imgUrl", Constants.imgUrl);
        request.setAttribute("staticUrl", Constants.staticUrl);
        return Boolean.TRUE;
    }
}
