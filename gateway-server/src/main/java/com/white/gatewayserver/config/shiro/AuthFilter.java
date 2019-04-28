package com.white.gatewayserver.config.shiro;

import com.white.gatewayserver.helper.JedisHelper;
import com.white.gatewayserver.util.jwt.JwtUtil;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Program: AuthFilter
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 18:25:50
 **/

public class AuthFilter extends AuthorizationFilter {

    @Autowired
    private JedisHelper jedisHelper;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader("Authorization");
        String username = JwtUtil.getUsername(token);
        String key = "permission_"+username;
        String uri = request.getRequestURI();
        boolean flag = jedisHelper.SETS.sismember(key,uri);
        return flag;
    }


}
