package com.white.userserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.white.userserver.common.Result;
import com.white.userserver.helper.JedisHelper;
import com.white.userserver.pojo.entity.TbUser;
import com.white.userserver.mapper.TbUserMapper;
import com.white.userserver.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    private static final Logger logger = LoggerFactory.getLogger(TbUserServiceImpl.class);

    @Autowired
    private JedisHelper jedisHelper;

    @Override
    @LcnTransaction
    public String execute(String value, String exFlag) {
        return null;
    }





}
