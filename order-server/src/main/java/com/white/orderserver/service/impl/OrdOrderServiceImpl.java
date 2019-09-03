package com.white.orderserver.service.impl;

import com.white.orderserver.pojo.entity.OrdOrder;
import com.white.orderserver.mapper.OrdOrderMapper;
import com.white.orderserver.service.OrdOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单总单表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@Service
public class OrdOrderServiceImpl extends ServiceImpl<OrdOrderMapper, OrdOrder> implements OrdOrderService {

}
