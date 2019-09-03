package com.white.userserver.util.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Program: TestList
 * @Description:
 * @Author: White
 * @DateTime: 2019-08-19 00:17:58
 **/

public class TestList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[10]);
        list.set(1,"test");
        System.out.println(list);
    }



}
