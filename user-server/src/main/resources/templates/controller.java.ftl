package ${cfg.controllerPath};


import ${cfg.pathUrl}.common.Result;
import ${cfg.packageInfo.Service}.${table.serviceName};
import ${cfg.packageInfo.Entity}.${table.entityName};
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
 * @table: ${table.name} (${table.comment})
 */
// @RequestMapping("/example")
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${cfg.nameLowwerCaseCamel}Service;

    /**
     * @api {post} ${cfg.controllerPath}/new 1、${table.comment}-新增信息
     * @apiGroup ${table.name}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.comment}-新增信息
     *
    <#list table.fields as TableField>
    <#if TableField.propertyName != "id">
     * @apiParam {${TableField.columnType}} [${TableField.propertyName}] <code>body</code>${TableField.comment}
    </#if>
    </#list>
     *
     * @apiParamExample {json} 请求样例:
     * {
    <#list table.fields as TableField>
    <#if TableField.propertyName != "id">
     *      "${TableField.propertyName}": "${TableField.propertyName}",
    </#if>
    </#list>
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
    public Result ${cfg.nameLowwerCaseCamel}New(HttpServletRequest request, @RequestBody ${table.entityName} model){
        Result result = new Result();
         // todo 按需添加限制条件
        model.setId(null);
        int id = ${cfg.nameLowwerCaseCamel}Service.getBaseMapper().insert(model);
        model.setId(id);
        result.setData(model);
        return result;
    }

    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ${cfg.nameLowwerCaseCamel}Remove(HttpServletRequest request, @RequestBody List<Integer> model){
        Result result = new Result();
         // todo 按需添加限制条件

        int count = ${cfg.nameLowwerCaseCamel}Service.getBaseMapper().deleteBatchIds(model);
        result.setData(count);
        return result;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ${cfg.nameLowwerCaseCamel}Update(HttpServletRequest request, @RequestBody ${table.entityName} model){
        Result result = new Result();
        // todo 按需添加限制条件

        if (model.getId() == null){
            return Result.requestByError("0","id can not be null");
        }
        ${table.entityName} target = ${cfg.nameLowwerCaseCamel}Service.getBaseMapper().selectById(model.getId());
        if (target == null){
            return Result.requestByError("0","id is error, data is not exist");
        }
        ${cfg.nameLowwerCaseCamel}Service.getBaseMapper().updateById(model);
        result.setData(model);
        return result;
    }

    @GetMapping("/page")
    public Result ${cfg.nameLowwerCaseCamel}Page(${table.entityName} model){
        Result result = new Result();
        // todo 按需添加限制条件
        IPage<${table.entityName}> page = new Page<>();
        page = ${cfg.nameLowwerCaseCamel}Service.page(page);
        result.setData(page);
        return result;
    }

    @GetMapping("/list")
    public Result ${cfg.nameLowwerCaseCamel}List(${table.entityName} model){
        Result result = new Result();
        // todo 按需添加限制条件

        Wrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();
        List<${table.entityName}> list = ${cfg.nameLowwerCaseCamel}Service.getBaseMapper().selectList(queryWrapper);
        result.setData(list);
        return result;
    }

}