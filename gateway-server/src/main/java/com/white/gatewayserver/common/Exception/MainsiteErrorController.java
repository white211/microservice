package com.white.gatewayserver.common.Exception;

import com.white.gatewayserver.common.Result;
import com.white.gatewayserver.common.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Program: MainsiteErrorController
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 16:51:58
 **/
@Controller
public class MainsiteErrorController implements ErrorController {

    @RequestMapping(value = "/500")
    @ResponseBody
    public Result handleUnauthorized(){
        return Result.requestByError(-1, "出现500错误");
    }

    @RequestMapping(value = "/403")
    @ResponseBody
    public Result handleNotToken(){
        return Result.requestByError(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getDesc());
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
