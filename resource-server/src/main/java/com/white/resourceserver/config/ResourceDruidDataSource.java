package com.white.resourceserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @Program: UserDruidDataSource
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 13:42:12
 **/

@Component
@MapperScan("com.white.resourceserver.mapper")
public class ResourceDruidDataSource {


}
