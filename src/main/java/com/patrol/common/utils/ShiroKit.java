package com.patrol.common.utils;

import com.patrol.domain.pojo.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/***
 * Shiro单点登录工具类
 *
 * @author WangSheng/2019-10-14
 */
public class ShiroKit {

    public final static String hashAlgorithmName = "MD5";
    public final static int hashIterations = 1024;

    /***
     * 加密
     *
     * @param content
     * @param salt
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static String md5(String content, String salt) {
        ByteSource byteSource = new Md5Hash(salt);
        return new SimpleHash(hashAlgorithmName, content, byteSource, hashIterations).toString();
    }

    /**
     * 获取当前Subject
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /***
     * 获取封装的 ShiroUser
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static ShiroUser getUser() {
        return (ShiroUser) getSubject().getPrincipals().getPrimaryPrincipal();
    }

    /***
     * 获取 Session
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /***
     * 获取 Shiro指定的 SessionKey
     *
     * @param key
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static <T> T getSessionAttr(String key) {
        Session session = getSession();
        return session != null ? (T) session.getAttribute(key) : null;
    }

    /***
     * 设置 Shiro指定的 SessionKey
     *
     * @param key
     * @param value
     *
     * @author WangSheng/2019-10-14
     */
    public static void setSessionAttr(String key, Object value) {
        Session session = getSession();
        session.setAttribute(key, value);
    }

    /***
     * 移除 Shiro指定的 SessionKey
     *
     * @param key
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static void removeSessionAttr(String key) {
        Session session = getSession();
        if (session != null){
            session.removeAttribute(key);
        }

    }

    /***
     * 验证角色
     *
     * @param roleName
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public static boolean hasRole(String roleName) {
        return getSubject() != null && roleName != null
                && roleName.length() > 0 && getSubject().hasRole(roleName);
    }

}
