package com.patrol.service;

import com.patrol.common.Pageable;
import com.patrol.common.Result;
import com.patrol.common.enums.ResultCode;
import com.patrol.common.utils.DateKit;
import com.patrol.common.utils.JsonKit;
import com.patrol.common.utils.ShiroKit;
import com.patrol.domain.User;
import com.patrol.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.*;

/***
 * 用户服务层
 *
 * @author WangSheng/2019-10-14
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /***
     * 后端登录
     *
     * @param account       账户
     * @param password      密码
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public Result adminLogin(String account, String password){
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            return Result.error(ResultCode.CODE_2);
        }
        try {
            Subject subject = ShiroKit.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password.toCharArray());
            token.setRememberMe(false);
            subject.login(token);
        } catch (AuthenticationException e) {
            return Result.success(ResultCode.CODE_3);
        } catch (Exception e) {
            return Result.error();
        }
        return Result.success(ShiroKit.getUser());
    }

    /**
     * 查询所有用户信息
     * @return
     */
    public List findAllUser() {
        Iterable<User> users = userRepository.findAll();
        List<User> list = new ArrayList<User>();
        users.forEach(user ->{
            list.add(user);
        });
        return list;
    }

    /**
     * 添加用户信息
     * @param map
     * @return
     */
    public Result addUser(Map<String, String> map) {
        try{
            String json = JsonKit.instance().writeValue(map);
            User user = JsonKit.instance().readValue(json, User.class);
            userRepository.save(user);
        }catch (Exception e){
            return Result.error(ResultCode.CODE_1);
        }
        return Result.success(ResultCode.CODE_0);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public Result deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            return Result.error(ResultCode.CODE_1);
        }
        return Result.success(ResultCode.CODE_0);
    }

    /**
     * 编辑用户
     * @param id
     * @return
     */
    public Result editUser(long id) {
        Optional<User> option = userRepository.findById(id);
        User user = option.get();
        if(user!=null){
            return Result.success(user);
        }else{
            return Result.error(ResultCode.CODE_1);
        }
    }

    /**
     * 查询用户
     * @param param
     * @param moudel
     * @return
     */
    public void findByNick(Map<String, String> param, Model moudel) {
        User user = userRepository.findByNick(param.get("nick"));
        if(user!=null){
            List<User> users = new ArrayList<User>();
            users.add(user);
            moudel.addAttribute("users",users);
        }
    }

    /**
     * 根据查询条件，对user表进行查询
     * @param param
     */
    public Pageable findByParams(Map<String, String> param) {
        Pageable pageable = userRepository.findByParams(param);
        List<Map<String, Object>> result = (List<Map<String, Object>>)pageable.getRows();
        result.forEach(item -> {
            item.put("modify_date_cn", DateKit.getDateFormat((Date) item.get("modify_date")));
            item.put("create_date_cn", DateKit.getDateFormat((Date) item.get("create_date")));
        });
        return pageable;
    }
}
