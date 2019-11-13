package com.white.resourceserver.controller.core;


import com.white.resourceserver.common.Result;
import com.white.resourceserver.service.ResProductCateService;
import com.white.resourceserver.pojo.entity.ResProductCate;
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
 * @table: res_product_cate (商品分类表)
 */
// @RequestMapping("/example")
public class ResProductCateController {

    @Autowired
    private ResProductCateService resProductCateService;

    /**
     * @api {post} /new 1、商品分类表-新增信息
     * @apiGroup res_product_cate
     *
     * @apiVersion 0.0.1
     * @apiDescription 商品分类表-新增信息
     *
     * @apiParam {STRING} [cateName] <code>body</code>分类名称
     * @apiParam {STRING} [cateDescription] <code>body</code>分类描述
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
     *      "cateName": "cateName",
     *      "cateDescription": "cateDescription",
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
    public Result resProductCateNew(HttpServletRequest request, @RequestBody ResProductCate model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = resProductCateService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result resProductCateRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = resProductCateService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result resProductCateUpdate(HttpServletRequest request, @RequestBody ResProductCate model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        ResProductCate target = resProductCateService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        resProductCateService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result resProductCatePage(ResProductCate model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<ResProductCate> page = new Page<>();
        page = resProductCateService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result resProductCateList(ResProductCate model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<ResProductCate> queryWrapper = new QueryWrapper<>();
        List<ResProductCate> list = resProductCateService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}