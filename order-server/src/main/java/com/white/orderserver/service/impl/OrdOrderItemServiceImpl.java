package com.white.orderserver.service.impl;

import com.white.orderserver.pojo.entity.OrdOrderItem;
import com.white.orderserver.mapper.OrdOrderItemMapper;
import com.white.orderserver.service.OrdOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author White
 * @since 2019-11-12
 */
@Service
public class OrdOrderItemServiceImpl extends ServiceImpl<OrdOrderItemMapper, OrdOrderItem> implements OrdOrderItemService {

}
