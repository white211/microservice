package ${controller.packagePath};

import ${project.commonLib}.base.BaseModel;
import ${project.commonLib}.base.PageData;
import ${project.commonLib}.base.Result;
import ${project.commonLib}.helper.BaseHelper;
import ${model.packagePath}.${table.nameUpperCaseCamel};
import ${repo.packagePath}.${table.nameUpperCaseCamel}Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;


/**
 * Description: Create by Shrimp Generator
 * @author: wangkaicun @ current time
 * @table: ${table.nameUnderLine} (${table.remarks})
 */
// @RequestMapping("/example")
public class ${table.nameUpperCaseCamel}Controller {

    @Autowired
    private ${table.nameUpperCaseCamel}Repo ${table.nameLowwerCaseCamel}Repo;

    /**
     * @api {get} ${table.controllerPath}/page 1、${table.remarks}-获取分页
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-获取分页
     *
    <#--
     * 以下类型不可用于对比
     * String : LONGTEXT,MEDIUMTEXT,TEXT
     * byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
    -->
    <#list table.columns as column>
    <#if column.typeName != "LONGTEXT" && column.typeName != "MEDIUMTEXT" && column.typeName != "TEXT" && column.typeName != "BINARY" && column.typeName != "BLOB" && column.typeName != "GEOMETRY" && column.typeName != "LONGBLOB" && column.typeName != "MEDIUMBLOB" && column.typeName != "TINYBLOB" && column.typeName != "VARBINARY">
     * @apiParam {${column.javaType}} [${column.nameLowwerCaseCamel}] <code>param</code>${column.remarks}
    </#if>
    </#list>
     *
     * @apiParamExample {param} 请求样例:
     * ?id=1
     *
    <#list table.columns as column>
     * @apiSuccess {${column.javaType}} [${column.nameLowwerCaseCamel}] ${column.remarks}
    </#list>
     *
     * @apiSuccessExample {json} 返回样例:
     * {
     *     "code": 1,
     *     "data": {
     *         "rows": [
     *             {
                        <#list table.columns as column>
     *                 "${column.nameLowwerCaseCamel}": "${column.nameLowwerCaseCamel}",
                        </#list>
     *             },
     *             ...
     *         ],
     *         "totalCount": 1,
     *         "totalPage": 1,
     *         "pageNo": 1,
     *         "pageSize": 10
     *     }
     * }
     *
     */
    @GetMapping("${table.controllerPath}/page")
    public Result ${table.nameLowwerCaseCamel}Page(${table.nameUpperCaseCamel} model){
        Result result = new Result();
        PageData<${table.nameUpperCaseCamel}> ${table.nameLowwerCaseCamel}s = ${table.nameLowwerCaseCamel}Repo.page(model);
        return result.setData(${table.nameLowwerCaseCamel}s);
    }

    /**
     * @api {get} ${table.controllerPath}/count 2、${table.remarks}-获取数量
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-获取数量
     *
    <#--
     * 以下类型不可用于对比
     * String : LONGTEXT,MEDIUMTEXT,TEXT
     * byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
    -->
    <#list table.columns as column>
    <#if column.typeName != "LONGTEXT" && column.typeName != "MEDIUMTEXT" && column.typeName != "TEXT" && column.typeName != "BINARY" && column.typeName != "BLOB" && column.typeName != "GEOMETRY" && column.typeName != "LONGBLOB" && column.typeName != "MEDIUMBLOB" && column.typeName != "TINYBLOB" && column.typeName != "VARBINARY">
     * @apiParam {${column.javaType}} [${column.nameLowwerCaseCamel}] <code>param</code>${column.remarks}
    </#if>
    </#list>
     *
     * @apiParamExample {param} 请求样例:
     * ?id=1
     *
     * @apiSuccess {Long} count 统计结果
     *
     * @apiSuccessExample {json} 返回样例:
     * {
     *     "code": 1,
     *     "data": {
     *          "count":12
     *      }
     * }
     *
     */
    @GetMapping("${table.controllerPath}/count")
    public Result ${table.nameLowwerCaseCamel}Count(${table.nameUpperCaseCamel} model){
        Result result = new Result();
        BaseModel baseModel = new BaseModel();
        baseModel.setCount(${table.nameLowwerCaseCamel}Repo.count(model));
        return result.setData(baseModel);
    }

    /**
     * @api {get} ${table.controllerPath}/detial 3、${table.remarks}-获取详情
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-获取详情
     *
     * @apiParam {Long} id <code>param</code>数据Id
     *
     * @apiParamExample {param} 请求样例:
     * ?id=1
     *
    <#list table.columns as column>
     * @apiSuccess {${column.javaType}} [${column.nameLowwerCaseCamel}] ${column.remarks}
    </#list>
     *
     * @apiSuccessExample {json} 返回样例:
     * {
     *     "code": 1,
     *     "data": {
                <#list table.columns as column>
     *          "${column.nameLowwerCaseCamel}": "${column.nameLowwerCaseCamel}",
                </#list>
     *     }
     * }
     *
     */
    @GetMapping("${table.controllerPath}/detial")
    public Result ${table.nameLowwerCaseCamel}Detial(${table.nameUpperCaseCamel} model){
        Result result = new Result();
        if (model.getId()==null){
            return result.setError("id can not be null");
        }
        model = ${table.nameLowwerCaseCamel}Repo.get(model.getId());
        if (model == null){
            return result.setError("id is error");
        }
        return result.setData(model);
    }

    /**
     * @api {post} ${table.controllerPath}/new 4、${table.remarks}-新增信息
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-新增信息
     *
    <#list table.columns as column>
    <#if column.nameLowwerCaseCamel != "id">
     * @apiParam {${column.javaType}} [${column.nameLowwerCaseCamel}] <code>body</code>${column.remarks}
    </#if>
    </#list>
     *
     * @apiParamExample {json} 请求样例:
     * {
            <#list table.columns as column>
            <#if column.nameLowwerCaseCamel != "id">
     *      "${column.nameLowwerCaseCamel}": "${column.nameLowwerCaseCamel}",
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
    @PostMapping("${table.controllerPath}/new")
    @Transactional(rollbackFor = Exception.class)
    public Result ${table.nameLowwerCaseCamel}New(HttpServletRequest req, @RequestBody ${table.nameUpperCaseCamel} model){
        Result result = new Result();

        // 按需添加限制条件

        model.setId(null);
        Long id = ${table.nameLowwerCaseCamel}Repo.insert(model, req);
        model.setId(id);
        return result.setData(model);
    }

    /**
     * @api {post} ${table.controllerPath}/update 5、${table.remarks}-更新信息
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-更新信息
     *
    <#list table.columns as column>
    <#if column.nameLowwerCaseCamel == "id">
     * @apiParam {${column.javaType}} ${column.nameLowwerCaseCamel} <code>body</code>${column.remarks}
    </#if>
    <#if column.nameLowwerCaseCamel != "id">
     * @apiParam {${column.javaType}} [${column.nameLowwerCaseCamel}] <code>body</code>${column.remarks}
    </#if>
    </#list>
     *
     * @apiParamExample {json} 请求样例:
     * {
            <#list table.columns as column>
     *      "${column.nameLowwerCaseCamel}": "${column.nameLowwerCaseCamel}",
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
    @PostMapping("${table.controllerPath}/update")
    @Transactional(rollbackFor = Exception.class)
    public Result ${table.nameLowwerCaseCamel}Update(HttpServletRequest req, @RequestBody ${table.nameUpperCaseCamel} model){
        Result result = new Result();

        if (model.getId() == null){
            return result.setError("id can not be null");
        }
        ${table.nameUpperCaseCamel} target = ${table.nameLowwerCaseCamel}Repo.get(model.getId());
        if (target == null){
            return result.setError("id is error, data is not exist");
        }
        ${table.nameUpperCaseCamel}.copyIfNotNull(model, target);

        ${table.nameLowwerCaseCamel}Repo.update(target,req);
        return result.setData(model);
    }

    /**
     * @api {post} ${table.controllerPath}/remove 6、${table.remarks}-删除【单个，批量】
     * @apiGroup ${table.controllerGroup}
     *
     * @apiVersion 0.0.1
     * @apiDescription ${table.remarks}-删除【单个，批量】
     *
     * @apiParam {Integer} [id] <code>body</code> 主键 id
     * @apiParam {Integer[]} [ids] <code>body</code> 主键 id组
     *
     * @apiParamExample {json} 请求样例:
     * {
     *     "id": 1,
     *     "ids": [1]
     * }
     *
     * @apiSuccessExample {json} 返回样例:
     * {
     *     "code": 1,
     *     "data": 1
     * }
     *
     */
    @PostMapping("${table.controllerPath}/remove")
    @Transactional(rollbackFor = Exception.class)
    public Result ${table.nameLowwerCaseCamel}Remove(HttpServletRequest req, @RequestBody BaseModel model){
        Result result = BaseHelper.removeCheck(model);
        if (result.getError()!=null){
            return result;
        }
        Integer rt = ${table.nameLowwerCaseCamel}Repo.del(model.getIds(),req);
        return result.setData(rt);
    }

}
