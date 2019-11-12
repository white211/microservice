package com.white.orderserver.controller.core;


import com.white.orderserver.common.Result;
import com.white.orderserver.service.OrdOrderDictService;
import com.white.orderserver.pojo.entity.OrdOrderDict;
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
 * @table: ord_order_dict (订单字典表)
 */
// @RequestMapping("/example")
public class OrdOrderDictController {

    @Autowired
    private OrdOrderDictService ordOrderDictService;

    /**
     * @api {post} /new 1、订单字典表-新增信息
     * @apiGroup ord_order_dict
     *
     * @apiVersion 0.0.1
     * @apiDescription 订单字典表-新增信息
     *
     * @apiParam {STRING} [code] <code>body</code>编码
     * @apiParam {STRING} [value] <code>body</code>值
     * @apiParam {STRING} [description] <code>body</code>描述
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
     *      "code": "code",
     *      "value": "value",
     *      "description": "description",
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
    public Result ordOrderDictNew(HttpServletRequest request, @RequestBody OrdOrderDict model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = ordOrderDictService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderDictRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = ordOrderDictService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ordOrderDictUpdate(HttpServletRequest request, @RequestBody OrdOrderDict model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        OrdOrderDict target = ordOrderDictService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        ordOrderDictService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result ordOrderDictPage(OrdOrderDict model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<OrdOrderDict> page = new Page<>();
        page = ordOrderDictService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result ordOrderDictList(OrdOrderDict model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<OrdOrderDict> queryWrapper = new QueryWrapper<>();
        List<OrdOrderDict> list = ordOrderDictService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}