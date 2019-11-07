package com.patrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.patrol.common.utils.ShiroKit.getSession;

@Controller
@RequestMapping({"/admin"})
public class AdminController extends BaseController {


    /**
     * 当前用户ID
     * @return
     */
    public Long getUserId(){
        return (Long) getSession().getAttribute("userId");
    }

    /**
     * 当前用户名称
     * @return
     */
    public String getUserName(){
        return (String) getSession().getAttribute("userName");
    }

}
