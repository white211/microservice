package com.white.orderserver.controller;


import com.white.orderserver.common.Result;
import com.white.orderserver.config.rabbitMq.sender.FirstSender;
import com.white.orderserver.pojo.dto.OrdOrderDto;
import com.white.orderserver.pojo.entity.OrdOrder;
import com.white.orderserver.pojo.entity.Product;
import com.white.orderserver.service.OrdOrderService;
import com.white.orderserver.util.OrderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单总单表 前端控制器
 * </p>
 *
 * @author White
 * @since 2019-05-13
 */
@RestController
@RequestMapping("/ordOrder")
public class OrdOrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrdOrderController.class);

    @Autowired
    private FirstSender firstSender;

    @Autowired
    private OrdOrderService ordOrderService;

    @PostMapping(Routes.ORDER_NEW)
    @Transactional(rollbackFor = Exception.class)
    public Result newOrder(@RequestBody OrdOrderDto data){
        String orderNo = OrderUtil.crateOrderNo();
        Integer amount = 0;
        OrdOrder ordOrder = new OrdOrder();
        ordOrder.setOrderNo(orderNo);
        for (Product product: data.getProductList()){
            if(product.getBuyAmount() != null){
                amount = amount+product.getBuyAmount();
            }
        }
        ordOrder.setProductAmount(amount);
        ordOrderService.insert(ordOrder);
        logger.info("打印新建订单信息"+ordOrder);
        data.setId(ordOrder.getId());
        firstSender.send(data.toString());
        return Result.requestBySuccess(ordOrder);
    }



}

