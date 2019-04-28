package com.white.gatewayserver.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Program: JwtToken
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 10:17:12
 **/

public class JwtToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
