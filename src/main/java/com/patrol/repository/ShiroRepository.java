package com.patrol.repository;

import com.patrol.common.utils.ShiroKit;
import com.patrol.domain.User;
import com.patrol.domain.pojo.ShiroUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/***
 * 自定义ShiroRepository
 *
 * @author WangSheng/2019-10-14
 */
@Repository
public class ShiroRepository extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    /***
     * 登录认证
     *
     * @param authToken
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        User user = userRepository.findByMobile(token.getUsername());
        return user==null? null : authentication(user,super.getName());
    }


    /***
     * 身份认证
     *
     * @param user
     * @param realmName
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    public SimpleAuthenticationInfo authentication(User user, String realmName){
        String password = user.getSecret();
        String secret = user.getSalt();
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        shiroUser.setMobile(user.getMobile());
        shiroUser.setNick(user.getNick());
        ByteSource credentialsSalt = new Md5Hash(secret);
        return new SimpleAuthenticationInfo(shiroUser, password,credentialsSalt, realmName);
    }

    /***
     * 权限认证
     *
     * @param principals
     *
     * @author WangSheng/2019-10-14
     *
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    /***
     * 设置加密方式
     *
     * @param credentialsMatcher
     *
     * @author WangSheng/2019-10-14
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }
}
