package com.patrol.controller;

import com.patrol.common.Pageable;
import com.patrol.common.enums.Pages;
import com.patrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DemoController extends AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    public String index(){
        return Pages.$ADMIN_OPUS.TEMPLATES;
    }

    @ResponseBody
    @RequestMapping("/demo/search")
    public Pageable search(@RequestParam Map<String, String> param){
        return userService.findByParams(param);
    }
}
