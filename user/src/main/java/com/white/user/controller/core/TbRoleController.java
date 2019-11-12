package com.white.user.controller.core;


import com.white.user.common.Result;
import com.white.user.service.TbRoleService;
import com.white.user.pojo.entity.TbRole;
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
 * @table: tb_role (角色表)
 */
// @RequestMapping("/example")
public class TbRoleController {

    @Autowired
    private TbRoleService tbRoleService;

    /**
     * @api {post} /new 1、角色表-新增信息
     * @apiGroup tb_role
     *
     * @apiVersion 0.0.1
     * @apiDescription 角色表-新增信息
     *
     * @apiParam {INTEGER} [pid] <code>body</code>父id
     * @apiParam {INTEGER} [leaf] <code>body</code>是否是叶子
     * @apiParam {STRING} [name] <code>body</code>名称
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
     *      "name": "name",
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
    public Result tbRoleNew(HttpServletRequest request, @RequestBody TbRole model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = tbRoleService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result tbRoleRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = tbRoleService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result tbRoleUpdate(HttpServletRequest request, @RequestBody TbRole model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        TbRole target = tbRoleService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        tbRoleService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result tbRolePage(TbRole model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<TbRole> page = new Page<>();
        page = tbRoleService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result tbRoleList(TbRole model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<TbRole> queryWrapper = new QueryWrapper<>();
        List<TbRole> list = tbRoleService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}