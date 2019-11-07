package com.patrol.controller;

import com.patrol.common.enums.Pages;
import com.patrol.common.utils.HttpKit;
import com.patrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebIndexController extends WebController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(Model model){
        model.addAttribute("ip", HttpKit.getIp(HttpKit.getRequest()));
        return Pages.$WEB_INDEX.TEMPLATES;
    }

}
