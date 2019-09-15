package com.white.userserver.controller.core;


import com.white.userserver.common.Result;
import com.white.userserver.service.TbResourceService;
import com.white.userserver.pojo.entity.TbResource;
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
 * @table: tb_resource (系统菜单表)
 */
// @RequestMapping("/example")
public class TbResourceController {

    @Autowired
    private TbResourceService tbResourceService;

    /**
     * @api {post} /new 1、系统菜单表-新增信息
     * @apiGroup tb_resource
     *
     * @apiVersion 0.0.1
     * @apiDescription 系统菜单表-新增信息
     *
     * @apiParam {INTEGER} [pid] <code>body</code>父id
     * @apiParam {INTEGER} [leaf] <code>body</code>是否是叶子
     * @apiParam {INTEGER} [typeId] <code>body</code>类型ID
     * @apiParam {STRING} [path] <code>body</code>页面路径
     * @apiParam {STRING} [component] <code>body</code>组件
     * @apiParam {STRING} [name] <code>body</code>名称
     * @apiParam {STRING} [redirect] <code>body</code>重定向
     * @apiParam {INTEGER} [hidden] <code>body</code>是否隐藏
     * @apiParam {STRING} [icon] <code>body</code>图标
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
     * @apiParam {INTEGER} [status] <code>body</code>status
     *
     * @apiParamExample {json} 请求样例:
     * {
     *      "pid": "pid",
     *      "leaf": "leaf",
     *      "typeId": "typeId",
     *      "path": "path",
     *      "component": "component",
     *      "name": "name",
     *      "redirect": "redirect",
     *      "hidden": "hidden",
     *      "icon": "icon",
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
    public Result tbResourceNew(HttpServletRequest request, @RequestBody TbResource model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = tbResourceService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result tbResourceRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = tbResourceService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result tbResourceUpdate(HttpServletRequest request, @RequestBody TbResource model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        TbResource target = tbResourceService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        tbResourceService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result tbResourcePage(TbResource model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<TbResource> page = new Page<>();
        page = tbResourceService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result tbResourceList(TbResource model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<TbResource> queryWrapper = new QueryWrapper<>();
        List<TbResource> list = tbResourceService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}