package com.white.userserver.service.impl;

import com.white.userserver.pojo.entity.TbUser;
import com.white.userserver.mapper.TbUserMapper;
import com.white.userserver.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-09-06
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
