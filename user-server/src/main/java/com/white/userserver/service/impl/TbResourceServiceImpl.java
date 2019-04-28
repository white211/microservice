package com.white.userserver.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.white.userserver.common.Result;
import com.white.userserver.pojo.entity.TbResource;
import com.white.userserver.mapper.TbResourceMapper;
import com.white.userserver.service.TbResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
@Service
public class TbResourceServiceImpl extends ServiceImpl<TbResourceMapper, TbResource> implements TbResourceService {

    @Override
    public Result getResourcePage() {
        Wrapper<TbResource> wrapper = new EntityWrapper<>();
        List<TbResource> list = this.baseMapper.selectList(wrapper);
        return Result.requestBySuccess(list);
    }
}
