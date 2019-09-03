package com.white.userserver.util.lambda;

import lombok.Data;

import java.util.Date;

/**
 * @Program: Person
 * @Description:
 * @Author: White
 * @DateTime: 2019-07-23 16:09:42
 **/
@Data
public class Person {

    private Integer id;

    private String name;

    private Integer sex;

    private Date birthday;

    private Integer age;

}


