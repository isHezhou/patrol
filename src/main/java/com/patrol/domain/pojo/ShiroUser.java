package com.patrol.domain.pojo;

/***
 * Shiro对象实体类
 *
 * @author WangSheng/2019-10-14
 *
 */
public class ShiroUser {

    public Long id;
    public String nick;
    public String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
