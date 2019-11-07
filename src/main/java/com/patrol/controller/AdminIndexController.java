package com.patrol.controller;


import com.patrol.common.Result;
import com.patrol.common.enums.Pages;
import com.patrol.common.utils.ShiroKit;
import com.patrol.domain.pojo.ShiroUser;
import com.patrol.service.UserService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/***
 * 后台主页控制器
 *
 * @author WangSheng/2019-10-14
 *
 * @return
 */
@Controller
public class AdminIndexController extends AdminController{

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return Pages.$ADMIN_LOGIN.TEMPLATES;
    }

    @RequestMapping("/console")
    public String console(Model model){
        model.addAttribute("nick",getSession().getAttribute("username"));
        return Pages.$ADMIN_CONSOLE.TEMPLATES;
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return Pages.$ADMIN_WELCOME.TEMPLATES;
    }

    /***
     * 登录
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginSubmit")
    public Result loginSubmit(@RequestParam Map<String, String> param){
        String account = param.get("account");
        String password = param.get("password");
        Result result = userService.adminLogin(account,password);
        if(result.isSuccess()){
            ShiroUser shiroUser = (ShiroUser)result.getData();
            getSession().setAttribute("shiroUser", shiroUser);
            getSession().setAttribute("userName", shiroUser.getNick());
            getSession().setAttribute("userId",shiroUser.getId());
            ShiroKit.getSession().setAttribute("sessionFlag", true);
        }
        return result;
    }

    /***
     * 退出登录
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logOut() {
        Subject subject = ShiroKit.getSubject();
        subject.logout();
        return Pages.$ADMIN_LOGIN.TEMPLATES;
    }

}
