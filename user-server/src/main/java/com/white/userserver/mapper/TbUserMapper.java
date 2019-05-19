package com.white.userserver.mapper;

import com.white.userserver.pojo.entity.TbResource;
import com.white.userserver.pojo.entity.TbUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    List<TbResource> getResource(TbUser tbUser);

}