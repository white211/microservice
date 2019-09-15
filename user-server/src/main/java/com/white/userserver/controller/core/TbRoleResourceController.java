package com.white.userserver.controller.core;


import com.white.userserver.common.Result;
import com.white.userserver.service.TbRoleResourceService;
import com.white.userserver.pojo.entity.TbRoleResource;
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
 * @table: tb_role_resource (角色菜单分配表)
 */
// @RequestMapping("/example")
public class TbRoleResourceController {

    @Autowired
    private TbRoleResourceService tbRoleResourceService;

    /**
     * @api {post} /new 1、角色菜单分配表-新增信息
     * @apiGroup tb_role_resource
     *
     * @apiVersion 0.0.1
     * @apiDescription 角色菜单分配表-新增信息
     *
     * @apiParam {INTEGER} [roleId] <code>body</code>角色ID
     * @apiParam {INTEGER} [resourceId] <code>body</code>菜单ID
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
     *      "roleId": "roleId",
     *      "resourceId": "resourceId",
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
    public Result tbRoleResourceNew(HttpServletRequest request, @RequestBody TbRoleResource model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = tbRoleResourceService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result tbRoleResourceRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = tbRoleResourceService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result tbRoleResourceUpdate(HttpServletRequest request, @RequestBody TbRoleResource model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        TbRoleResource target = tbRoleResourceService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        tbRoleResourceService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result tbRoleResourcePage(TbRoleResource model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<TbRoleResource> page = new Page<>();
        page = tbRoleResourceService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result tbRoleResourceList(TbRoleResource model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<TbRoleResource> queryWrapper = new QueryWrapper<>();
        List<TbRoleResource> list = tbRoleResourceService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}