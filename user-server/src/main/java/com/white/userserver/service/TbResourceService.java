package com.white.userserver.service;

import com.white.userserver.common.Result;
import com.white.userserver.pojo.entity.TbResource;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务类
 * </p>
 *
 * @author White
 * @since 2019-04-28
 */
public interface TbResourceService extends IService<TbResource> {

    Result getResourcePage();

}
