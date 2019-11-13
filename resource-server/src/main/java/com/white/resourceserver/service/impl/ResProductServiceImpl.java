package com.white.resourceserver.service.impl;

import com.white.resourceserver.pojo.entity.ResProduct;
import com.white.resourceserver.mapper.ResProductMapper;
import com.white.resourceserver.service.ResProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-11-12
 */
@Service
public class ResProductServiceImpl extends ServiceImpl<ResProductMapper, ResProduct> implements ResProductService {

}
