package com.white.gatewayserver.common.Exception;

import com.white.gatewayserver.common.Result;
import lombok.Data;

/**
 * @Program: CommonException
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 10:52:59
 **/

@Data
public class CommonException extends RuntimeException{

    private Result result;

    public CommonException(Result result){
        this.result = result;
    }

}
