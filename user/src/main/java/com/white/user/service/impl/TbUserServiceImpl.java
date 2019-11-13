package com.white.user.service.impl;

import com.white.user.pojo.entity.TbUser;
import com.white.user.mapper.TbUserMapper;
import com.white.user.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-11-12
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Override
    public int newUser(TbUser model) {
        return this.baseMapper.insert(model);
    }
}
