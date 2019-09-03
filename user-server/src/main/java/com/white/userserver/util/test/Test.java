package com.white.userserver.util.test;

/**
 * @Program: Test
 * @Description:
 * @Author: White
 * @DateTime: 2019-07-08 23:09:45
 **/

public class Test {

    public static void main(String[] args) {
        System.out.println(Test2.a);
    }

}
class Test2{
    static {
        System.out.print("OK");
    }

    public static final String a=new String("JD");



}
