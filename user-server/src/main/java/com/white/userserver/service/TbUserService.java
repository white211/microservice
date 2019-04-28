package com.white.userserver.service;

import com.white.userserver.common.Result;
import com.white.userserver.pojo.entity.TbUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
public interface TbUserService extends IService<TbUser> {

    Result login(TbUser tbUser);

    Result getUserPage();
}
