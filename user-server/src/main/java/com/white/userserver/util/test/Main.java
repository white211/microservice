package com.white.userserver.util.test;

/**
 * @Program: Main
 * @Description:
 * @Author: White
 * @DateTime: 2019-07-08 23:07:10
 **/

public class Main {

    public static void main(String[] args) {
        System.out.println("A");
        new Main();
        new Main();
    }

    public Main() {
        System.out.println("B");
    }

    {
        System.out.println("C");
    }

    static {
        System.out.println("D");
    }

}
