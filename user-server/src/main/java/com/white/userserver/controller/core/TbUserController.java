package com.white.userserver.controller.core;


import com.white.userserver.common.Result;
import com.white.userserver.service.TbUserService;
import com.white.userserver.pojo.entity.TbUser;
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
 * @table: tb_user (用户表)
 */
// @RequestMapping("/example")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * @api {post} /new 1、用户表-新增信息
     * @apiGroup tb_user
     *
     * @apiVersion 0.0.1
     * @apiDescription 用户表-新增信息
     *
     * @apiParam {STRING} [username] <code>body</code>用户名
     * @apiParam {STRING} [password] <code>body</code>密码
     * @apiParam {INTEGER} [sex] <code>body</code>性别  0 女 1 男 2 未知
     * @apiParam {INTEGER} [age] <code>body</code>年龄
     * @apiParam {STRING} [email] <code>body</code>邮箱
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
     *      "username": "username",
     *      "password": "password",
     *      "sex": "sex",
     *      "age": "age",
     *      "email": "email",
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
    public Result tbUserNew(HttpServletRequest request, @RequestBody TbUser model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = tbUserService.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result tbUserRemove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = tbUserService.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result tbUserUpdate(HttpServletRequest request, @RequestBody TbUser model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        TbUser target = tbUserService.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        tbUserService.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result tbUserPage(TbUser model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<TbUser> page = new Page<>();
        page = tbUserService.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result tbUserList(TbUser model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<TbUser> queryWrapper = new QueryWrapper<>();
        List<TbUser> list = tbUserService.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}