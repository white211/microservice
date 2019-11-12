package com.white.report.common.Exception;

import com.white.report.common.Result;
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
