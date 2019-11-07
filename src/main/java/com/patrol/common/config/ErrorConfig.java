package com.patrol.common.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 全局异常拦截跳转配置
 *
 * @author WangSheng/2019-10-12
 *
 */
@Controller
public class ErrorConfig implements ErrorController {

    private static final String PATH_404 = "/error";

    @RequestMapping(ErrorConfig.PATH_404)
    public String error() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return ErrorConfig.PATH_404;
    }
}
