package com.white.orderserver.controller.custom;

import com.white.orderserver.common.Result;
import com.white.orderserver.config.rabbitMq.sender.FirstSender;
import com.white.orderserver.config.redission.util.RedissonLockUtil;
import com.white.orderserver.pojo.entity.OrdOrder;
import com.white.orderserver.service.OrdOrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @Program: OrderController
 * @Description:
 * @Author: White
 * @DateTime: 2019-11-12 18:55:20
 **/
@RestController
public class OrderController implements Routes {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrdOrderService ordOrderService;

    @Autowired
    private FirstSender firstSender;

    @PostMapping(ORDER_NEW)
    @Transactional(rollbackFor = Exception.class)
    public Result newOrder(@RequestBody OrdOrder model){
        Result result = new Result();
        String key = "key";
        try{
            RedissonLockUtil.lock(key);
            logger.info(">>>>>>>>>>>>>开始加锁<<<<<<<<<<<<<<");
            model.setId(null);
            boolean flag = ordOrderService.save(model);
            firstSender.send(model.toString());
            result.setMsg(String.valueOf(flag));
            result.setData(model);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            logger.info(">>>>>>>>>>>>>>释放锁<<<<<<<<<<<<<<<<<<<");
            RedissonLockUtil.unlock(key);
        }
        return result;
    }

}
