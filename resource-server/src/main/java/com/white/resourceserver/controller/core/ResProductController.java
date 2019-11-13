package com.white.resourceserver.controller.core;


import com.white.resourceserver.common.Result;
import com.white.resourceserver.service.ResProductService;
import com.white.resourceserver.pojo.entity.ResProduct;
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
 * @table: res_product (商品表)
 */
// @RequestMapping("/example")
public class ResProductController {

    @Autowired
    private ResProductService resProductService;

    /**
     * @api {post} /new 1、商品表-新增信息
     * @apiGroup res_product
     *
     * @apiVersion 0.0.1
     * @apiDescription 商品表-新增信息
     *
     * @apiParam {STRING} [name] <code>body</code>商品名称
     * @apiParam {STRING} [description] <code>body</code>商品描述
     * @apiParam {INTEGER} [amount] <code>body</code>商品数量
     * @apiParam {BIG_DECIMAL} [price] <code>body</code>商品价格
     * @apiParam {INTEGER} [discountType] <code>body</code>打折类型
     * @apiParam {BIG_DECIMAL} [discountRate] <code>body</code>打折折扣率
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
     *      "name": "name",
     *      "description": "description",
     *      "amount": "amount",
     *      "price": "price",
     *      "discountType": "discountType",
     *      "discountRate": "discountRate",
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
    public Result resProductNew(HttpServletRequest request, @RequestBody ResProduct model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = resProductService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result resProductRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = resProductService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result resProductUpdate(HttpServletRequest request, @RequestBody ResProduct model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        ResProduct target = resProductService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        resProductService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result resProductPage(ResProduct model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<ResProduct> page = new Page<>();
        page = resProductService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result resProductList(ResProduct model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<ResProduct> queryWrapper = new QueryWrapper<>();
        List<ResProduct> list = resProductService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}