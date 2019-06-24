package com.white.gatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.white.gatewayserver.helper.JedisHelper;
import com.white.gatewayserver.util.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @Program: PreFilter
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-19 17:31:09
 **/
@Component
public class PreFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Autowired
    private JedisHelper jedisHelper;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        logger.info("确定经过网关");

        //判读token是否失效
        String token = request.getHeader("token");
        logger.info("获取头部的token:   "+token);
        String userId = JwtUtil.getUserId(token);
        Set<String> set = jedisHelper.SETS.smembers("permission_"+userId);
        logger.info("打印获取到集合："+set);

        // TODO: 2019/6/19 判断该url 是否能被访问


        return null;
    }
}
