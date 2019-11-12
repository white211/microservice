package com.white.orderserver.controller.core;


import com.white.orderserver.common.Result;
import com.white.orderserver.service.OrdOrderService;
import com.white.orderserver.pojo.entity.OrdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Description: Create by mybatis-plus Generator
 * @author: white @ current time
 * @table: ord_order (订单总单表)
 */
// @RequestMapping("/example")
public class OrdOrderController {

    @Autowired
    private OrdOrderService ordOrderService;

    /**
     * @api {post} /new 1、订单总单表-新增信息
     * @apiGroup ord_order
     *
     * @apiVersion 0.0.1
     * @apiDescription 订单总单表-新增信息
     *
     * @apiParam {STRING} [orderNo] <code>body</code>订单编号
     * @apiParam {INTEGER} [productAmount] <code>body</code>商品数量
     * @apiParam {BIG_DECIMAL} [productPrice] <code>body</code>商品价格
     * @apiParam {BIG_DECIMAL} [orderPrice] <code>body</code>订单实收价格
     * @apiParam {BIG_DECIMAL} [discountPrice] <code>body</code>订单优惠价格
     * @apiParam {LOCAL_DATE_TIME} [payTime] <code>body</code>付款时间
     * @apiParam {LOCAL_DATE_TIME} [deliverTime] <code>body</code>发货时间
     * @apiParam {LOCAL_DATE_TIME} [receiveTime] <code>body</code>收货时间
     * @apiParam {LOCAL_DATE_TIME} [refundTime] <code>body</code>退款时间
     * @apiParam {INTEGER} [logisticId] <code>body</code>物流公司id
     * @apiParam {STRING} [logisticNo] <code>body</code>物流编号
     * @apiParam {INTEGER} [payChannelType] <code>body</code>订单支付方式
     * @apiParam {STRING} [outTradeNo] <code>body</code>订单支付交易号
     * @apiParam {INTEGER} [sort] <code>body</code>排序
     * @apiParam {INTEGER} [enableFlag] <code>body</code>可用状态
     * @apiParam {LOCAL_DATE_TIME} [enableBegin] <code>body</code>可用开始
     * @apiParam {LOCAL_DATE_TIME} [enableEnd] <code>body</code>可用结束
     * @apiParam {LOCAL_DATE_TIME} [createTime] <code>body</code>创建时间
     * @apiParam {INTEGER} [createBy] <code>body</code>创建人
     * @apiParam {LOCAL_DATE_TIME} [lastUpdateTime] <code>body</code>最后更新时间
     * @apiParam {INTEGER} [lastUpdateBy] <code>body</code>最后更新人
     * @apiParam {STRING} [comments] <code>body</code>备注
     * @apiParam {INTEGER} [version] <code>body</code>版本号
     * @apiParam {INTEGER} [status] <code>body</code>状态
     *
     * @apiParamExample {json} 请求样例:
     * {
     *      "orderNo": "orderNo",
     *      "productAmount": "productAmount",
     *      "productPrice": "productPrice",
     *      "orderPrice": "orderPrice",
     *      "discountPrice": "discountPrice",
     *      "payTime": "payTime",
     *      "deliverTime": "deliverTime",
     *      "receiveTime": "receiveTime",
     *      "refundTime": "refundTime",
     *      "logisticId": "logisticId",
     *      "logisticNo": "logisticNo",
     *      "payChannelType": "payChannelType",
     *      "outTradeNo": "outTradeNo",
     *      "sort": "sort",
     *      "enableFlag": "enableFlag",
     *      "enableBegin": "enableBegin",
     *      "enableEnd": "enableEnd",
     *      "createTime": "createTime",
     *      "createBy": "createBy",
     *      "lastUpdateTime": "lastUpdateTime",
     *      "lastUpdateBy": "lastUpdateBy",
     *      "comments": "comments",
     *      "version": "version",
     *      "status": "status",
     * }
     *
     * @apiSuccessExample {json} 返回样例:
     * {
     *     "code": 1,
     *     "data": ObjectModel
     * }
     *
     */
    @PostMapping("/new")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderNew(HttpServletRequest request, @RequestBody OrdOrder model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = ordOrderService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = ordOrderService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderUpdate(HttpServletRequest request, @RequestBody OrdOrder model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        OrdOrder target = ordOrderService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        ordOrderService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result ordOrderPage(OrdOrder model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<OrdOrder> page = new Page<>();
        page = ordOrderService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result ordOrderList(OrdOrder model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<OrdOrder> queryWrapper = new QueryWrapper<>();
        List<OrdOrder> list = ordOrderService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}