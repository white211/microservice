package com.white.userserver.controller;

import com.white.userserver.common.Desc;
import org.aspectj.lang.annotation.DeclareError;

/**
 * @Program: Routes
 * @Description:  请求的url
 * @Author: White
 * @DateTime: 2019-04-28 11:38:27
 **/

public class Routes {

    @Desc("用户登陆")
    public static final String TB_USER_LOGIN = "/login";

    @Desc("用户分页")
    public static final String TB_USER_PAGE  = "/page";

    @Desc("资源列表")
    public static final String TB_RESOURCE_PAGE = "/resource/page";

}
