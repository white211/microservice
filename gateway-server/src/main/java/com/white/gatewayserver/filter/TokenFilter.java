package com.white.gatewayserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.white.gatewayserver.common.Exception.CommonException;
import com.white.gatewayserver.common.Result;
import com.white.gatewayserver.helper.JedisHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Program: TokenFilter
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-19 22:12:54
 **/
@Component
public class TokenFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Autowired
    private JedisHelper jedisHelper;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
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
        if(StringUtils.isBlank(token)){
            logger.info("token为空");
            // TODO: 2019/6/19 所以需要处理返回失效
            throw new CommonException(new Result("token过期了"));
        }

        String redisToken = jedisHelper.STRINGS.get(token);
        if(StringUtils.isBlank(redisToken)){
            logger.info("token 已经过期了 请重新登陆");
            // TODO: 2019/6/19 所以需要处理返回失效
            throw new CommonException(new Result("token过期了"));
        }

        return null;
    }
}
