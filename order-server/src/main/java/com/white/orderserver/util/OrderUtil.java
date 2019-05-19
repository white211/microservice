package com.white.orderserver.util;

/**
 * @Program: OrderUtil
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:25:23
 **/

public class OrderUtil {

    public static String crateOrderNo(){
        String str = String.valueOf(System.currentTimeMillis());
        String str2 = String.valueOf((int)((Math.random()*9+1)*100000));
        return str+str2;
    }

}
