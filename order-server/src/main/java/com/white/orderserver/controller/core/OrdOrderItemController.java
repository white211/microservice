package com.white.orderserver.controller.core;


import com.white.orderserver.common.Result;
import com.white.orderserver.service.OrdOrderItemService;
import com.white.orderserver.pojo.entity.OrdOrderItem;
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
 * @table: ord_order_item (订单详情表)
 */
// @RequestMapping("/example")
public class OrdOrderItemController {

    @Autowired
    private OrdOrderItemService ordOrderItemService;

    /**
     * @api {post} /new 1、订单详情表-新增信息
     * @apiGroup ord_order_item
     *
     * @apiVersion 0.0.1
     * @apiDescription 订单详情表-新增信息
     *
     * @apiParam {INTEGER} [orderId] <code>body</code>订单编号id
     * @apiParam {INTEGER} [productId] <code>body</code>商品编号id
     * @apiParam {INTEGER} [buyAmount] <code>body</code>购买数量
     * @apiParam {STRING} [productName] <code>body</code>商品名称
     * @apiParam {BIG_DECIMAL} [productPrice] <code>body</code>商品单价
     * @apiParam {BIG_DECIMAL} [discountPrice] <code>body</code>优惠价格
     * @apiParam {BIG_DECIMAL} [itemPrice] <code>body</code>实付价格
     * @apiParam {INTEGER} [discountType] <code>body</code>打折类型
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
     *      "productId": "productId",
     *      "buyAmount": "buyAmount",
     *      "productName": "productName",
     *      "productPrice": "productPrice",
     *      "discountPrice": "discountPrice",
     *      "itemPrice": "itemPrice",
     *      "discountType": "discountType",
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
    public Result ordOrderItemNew(HttpServletRequest request, @RequestBody OrdOrderItem model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = ordOrderItemService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderItemRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = ordOrderItemService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderItemUpdate(HttpServletRequest request, @RequestBody OrdOrderItem model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        OrdOrderItem target = ordOrderItemService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        ordOrderItemService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result ordOrderItemPage(OrdOrderItem model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<OrdOrderItem> page = new Page<>();
        page = ordOrderItemService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result ordOrderItemList(OrdOrderItem model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<OrdOrderItem> queryWrapper = new QueryWrapper<>();
        List<OrdOrderItem> list = ordOrderItemService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}