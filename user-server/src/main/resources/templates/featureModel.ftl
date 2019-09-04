package ${model.packagePath};

import com.fasterxml.jackson.annotation.JsonInclude;
${DATETIME_FORMAT?if_exists}
${JSON_FORMAT?if_exists}
import ${project.commonLib}.base.BaseModel;
import ${project.commonLib}.util.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

${BIGDECIMAL?if_exists}
${DATETIME?if_exists}
import java.util.List;

/**
 * Description: Create by Shrimp Generator
 * @author: wangkaicun @ current time
 * @table: ${table.nameUnderLine} (${table.remarks?if_exists})
 */

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ${table.nameUpperCaseCamel} extends BaseModel {
<#--
* Boolean : BIT
* Integer : INT,INTEGER,MEDIUMINT
* Long : BIGINT
* Float : FLOAT
* Double : DOUBLE,REAL
* String : CHAR,VARCHAR,TEXT,MEDIUMTEXT,TINYTEXT,LONGTEXT,JSON
* Date : TIME,DATE,DATETIME,TIMESTAMP,YEAR 【需要 import】
* BigDecimal : DECIMAL,NUMERIC 【需要 import】
* Byte : TINYINT
* byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
* Object : GEOMETRYCOLLECTION,LINESTRING,MULTILINESTRING,MULTIPOINT,MULTIPOLYGON,POINT,POLYGON
-->

<#list table.columns as column>
    /**
     * ${column.remarks?if_exists}
     */
    <#if column.typeName == "BIT">
    private Boolean ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "INT" || column.typeName == "INTEGER" || column.typeName == "MEDIUMINT">
    private Integer ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "BIGINT">
    private Long ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "FLOAT">
    private Float ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "DOUBLE" || column.typeName == "REAL">
    private Double ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "CHAR" || column.typeName == "VARCHAR" || column.typeName == "TEXT" || column.typeName == "MEDIUMTEXT" || column.typeName == "TINYTEXT" || column.typeName == "LONGTEXT" || column.typeName == "JSON">
    private String ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "TIME" || column.typeName == "DATE" || column.typeName == "DATETIME" || column.typeName == "TIMESTAMP" || column.typeName == "YEAR" >
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "DECIMAL" || column.typeName == "NUMERIC" >
    private BigDecimal ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "TINYINT">
    private Byte ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "BINARY" || column.typeName == "BLOB" || column.typeName == "GEOMETRY" || column.typeName == "LONGBLOB" || column.typeName == "MEDIUMBLOB" || column.typeName == "TINYBLOB" || column.typeName == "VARBINARY">
    private byte[] ${column.nameLowwerCaseCamel};
    </#if>
    <#if column.typeName == "GEOMETRYCOLLECTION" || column.typeName == "LINESTRING" || column.typeName == "MULTILINESTRING" || column.typeName == "MULTIPOINT" || column.typeName == "MULTIPOLYGON" || column.typeName == "POINT" || column.typeName == "POLYGON" >
    private Object ${column.nameLowwerCaseCamel};
    </#if>

</#list>

    public static ${table.nameUpperCaseCamel} copy(${table.nameUpperCaseCamel} source, ${table.nameUpperCaseCamel} target){
        if (target == null ){ target = new ${table.nameUpperCaseCamel}();}
        if (source == null){ return target; }
        <#list table.columns as column>
        target.set${column.nameUpperCaseCamel}(source.get${column.nameUpperCaseCamel}());
        </#list>
        return target;
    }

    public static ${table.nameUpperCaseCamel} copyIfNotNull(${table.nameUpperCaseCamel} source, ${table.nameUpperCaseCamel} target){
        if (target == null ){ target = new ${table.nameUpperCaseCamel}();}
        if (source == null){ return target; }
        <#list table.columns as column>
        if (source.get${column.nameUpperCaseCamel}() != null){ target.set${column.nameUpperCaseCamel}(source.get${column.nameUpperCaseCamel}()); }
        </#list>
        return target;
    }

    public static ${table.nameUpperCaseCamel}Example createDelExample(List<Long> ids){
        ${table.nameUpperCaseCamel}Example example = new ${table.nameUpperCaseCamel}Example();
        ${table.nameUpperCaseCamel}Example.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return example;
    }

    public static ${table.nameUpperCaseCamel}Example createExample(${table.nameUpperCaseCamel} model){

        ${table.nameUpperCaseCamel}Example example = new ${table.nameUpperCaseCamel}Example();
        ${table.nameUpperCaseCamel}Example.Criteria criteria = example.createCriteria();

        // base
        criteria.andStatusEqualTo(1);

        if (model==null){ model = new ${table.nameUpperCaseCamel}(); }

        // id 和 ids 取交集
        if (model.getIds()!=null && model.getIds().size()>0){ criteria.andIdIn(model.getIds()); }

        //criterias
        <#--
        * 以下类型不可用于对比
        * String : LONGTEXT,MEDIUMTEXT,TEXT
        * byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
        -->
        <#list table.columns as column>
        <#if column.typeName != "LONGTEXT" && column.typeName != "MEDIUMTEXT" && column.typeName != "TEXT" && column.typeName != "BINARY" && column.typeName != "BLOB" && column.typeName != "GEOMETRY" && column.typeName != "LONGBLOB" && column.typeName != "MEDIUMBLOB" && column.typeName != "TINYBLOB" && column.typeName != "VARBINARY">
        if (model.get${column.nameUpperCaseCamel}()!=null){ criteria.and${column.nameUpperCaseCamel}EqualTo(model.get${column.nameUpperCaseCamel}()); }
        </#if>
        </#list>

        // BASE
        if (model.getTimeFrom() != null ) { criteria.andCreateTimeGreaterThanOrEqualTo(model.getTimeFrom()); }
        if (model.getTimeTo() != null ) { criteria.andCreateTimeLessThanOrEqualTo(model.getTimeTo()); }
        example.setOrderByClause(DEFAULE_ORDER_BY);
        if (model.getOrderBy()!=null) {
            example.setOrderByClause(StringUtil.camelToUnderline(model.getOrderBy()));
        }
        return example;
    }

}
