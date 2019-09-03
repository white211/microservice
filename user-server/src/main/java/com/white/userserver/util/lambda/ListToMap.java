package com.white.userserver.util.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Program: ListToMap
 * @Description:
 * @Author: White
 * @DateTime: 2019-07-23 11:57:52
 **/

public class ListToMap {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setName("white");
        person.setSex(1);
        person.setAge(24);
        person.setBirthday(new Date());
        person.setId(1);
        list.add(person);

        Person person1 = new Person();
        person1.setName("red");
        person1.setSex(2);
        person1.setAge(18);
        person1.setBirthday(new Date());
        person1.setId(2);
        list.add(person1);

        Map<Integer,String> map = new HashMap<>();
        map = list.stream().collect(Collectors.toMap(Person::getId,Person::getName));
        System.out.println(map);
    }


}



