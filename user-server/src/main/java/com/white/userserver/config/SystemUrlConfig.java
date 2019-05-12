package com.white.userserver.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.white.userserver.helper.JedisHelper;
import com.white.userserver.pojo.entity.TbResource;
import com.white.userserver.service.TbResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Program: SystemUrlConfig
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-29 00:04:01
 **/

@Configuration
public class SystemUrlConfig implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SystemUrlConfig.class);

    @Autowired
    private JedisHelper jedisHelper;

    @Autowired
    private TbResourceService tbResourceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("初始化url数据");
        Wrapper<TbResource> wrapper = new EntityWrapper<>();
        wrapper.in("status","1");
        List<TbResource> list = tbResourceService.selectList(wrapper);
        //
        String key = "sys_url";
        for (TbResource tbResource : list){
           jedisHelper.SETS.sadd(key,tbResource.getPath());
        }
        logger.info("初始话url数据条数"+list.size());
    }
}
