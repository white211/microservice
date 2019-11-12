package com.white.orderserver.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: MybatisPlusConfig
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 11:03:02
 **/
@Configuration
@MapperScan("com.white.orderserver.mapper.*")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
