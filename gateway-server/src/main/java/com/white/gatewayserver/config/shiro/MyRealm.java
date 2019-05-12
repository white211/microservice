package com.white.gatewayserver.config.shiro;

import com.white.gatewayserver.util.jwt.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Program: MyRealm
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 10:17:46
 **/
@Service
public class MyRealm  extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

//    @Autowired
//    private JedisHelper jedisHelper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JwtUtil.getUsername(principalCollection.toString());
//        String key = "permission_"+username;
//        String key1 = "role_"+username;
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        Set<String> set = jedisHelper.SETS.smembers(key);
//        logger.info("打印获取到的用户资源"+set);
//        simpleAuthorizationInfo.addStringPermissions(set);
        //
//        Set<String> set1 = jedisHelper.SETS.smembers(key1);
//        simpleAuthorizationInfo.addRoles(set1);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

//        String str  = jedisHelper.STRINGS.get(token);
//        TbUser tbUser = JSON.parseObject(str,TbUser.class);

//        if (tbUser == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
//        if (! JwtUtil.verify(token, username, tbUser.getPassword())) {
//            throw new AuthenticationException("Username or password error");
//        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

}
