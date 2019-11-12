package com.white.orderserver.controller.core;


import com.white.orderserver.common.Result;
import com.white.orderserver.service.OrdOrderFlowService;
import com.white.orderserver.pojo.entity.OrdOrderFlow;
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
 * @table: ord_order_flow (订单流水表)
 */
// @RequestMapping("/example")
public class OrdOrderFlowController {

    @Autowired
    private OrdOrderFlowService ordOrderFlowService;

    /**
     * @api {post} /new 1、订单流水表-新增信息
     * @apiGroup ord_order_flow
     *
     * @apiVersion 0.0.1
     * @apiDescription 订单流水表-新增信息
     *
     * @apiParam {INTEGER} [orderId] <code>body</code>订单编号id
     * @apiParam {STRING} [changeReason] <code>body</code>订单变化原因
     * @apiParam {BIG_DECIMAL} [orderPriceBefore] <code>body</code>价格变化前
     * @apiParam {BIG_DECIMAL} [orderPriceAfter] <code>body</code>价格变化后
     * @apiParam {INTEGER} [orderStatusBefore] <code>body</code>状态变化前
     * @apiParam {INTEGER} [orderStatusAfter] <code>body</code>状态变化后
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
     *      "orderId": "orderId",
     *      "changeReason": "changeReason",
     *      "orderPriceBefore": "orderPriceBefore",
     *      "orderPriceAfter": "orderPriceAfter",
     *      "orderStatusBefore": "orderStatusBefore",
     *      "orderStatusAfter": "orderStatusAfter",
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
    public Result ordOrderFlowNew(HttpServletRequest request, @RequestBody OrdOrderFlow model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = ordOrderFlowService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderFlowRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = ordOrderFlowService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderFlowUpdate(HttpServletRequest request, @RequestBody OrdOrderFlow model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        OrdOrderFlow target = ordOrderFlowService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        ordOrderFlowService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result ordOrderFlowPage(OrdOrderFlow model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<OrdOrderFlow> page = new Page<>();
        page = ordOrderFlowService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result ordOrderFlowList(OrdOrderFlow model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<OrdOrderFlow> queryWrapper = new QueryWrapper<>();
        List<OrdOrderFlow> list = ordOrderFlowService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}