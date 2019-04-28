package com.white.userserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @Program: UserDruidDataSource
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 13:42:12
 **/

@Component
@MapperScan("com.white.userserver.mapper")
public class UserDruidDataSource {


}
