package ${esRepo.packagePath};

import ${dto.packagePath}.${table.nameUpperCaseCamel}Dto;
import ${root.commonLib}.base.BaseDto;
import ${root.commonLib}.base.BaseRepo;
import ${root.commonLib}.base.PageData;
import ${root.commonLib}.util.DateUtil;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

@Component
public class ${table.nameUpperCaseCamel}EsRepo extends BaseRepo {

    private static final String TABLE = "${table.nameUnderLine}";

    @Autowired
    private Connection conn;
    @Autowired
    private RestHighLevelClient client;

    public ${table.nameUpperCaseCamel}Dto insert(${table.nameUpperCaseCamel}Dto dto){
        insertEs(client, TABLE, dto);
        return dto;
    }

    public ${table.nameUpperCaseCamel}Dto get(Integer id){
        if (id == null){
            throw new RuntimeException("id is null");
        }
        ${table.nameUpperCaseCamel}Dto dto = new ${table.nameUpperCaseCamel}Dto();
        dto.setId(id);
        return get(dto);
    }

    public ${table.nameUpperCaseCamel}Dto get(${table.nameUpperCaseCamel}Dto dto){
        String sql = "SELECT * FROM " + TABLE + createWhere(dto);
        List<${table.nameUpperCaseCamel}Dto> list = selectEs(conn, sql, ${table.nameUpperCaseCamel}Dto.class);
        if (list == null || list.size() == 0){
            return null;
        }
        if (list.size() > 1){
            throw new RuntimeException("查询结果不唯一，存在 "+ list.size() +" 条，请确保数据完整性，或者换用 list 查询");
        }
        return list.get(0);
    }

    public long count(){
        return count(null);
    }

    public long count(${table.nameUpperCaseCamel}Dto dto){
        String  sql = "SELECT COUNT(*) count FROM " + TABLE + createWhere(dto);
        List<BaseDto> list = selectEs(conn, sql, BaseDto.class);
        return list.get(0).getCount();
    }

    public List<${table.nameUpperCaseCamel}Dto> list(){
        return list(null);
    }

    public List<${table.nameUpperCaseCamel}Dto> list(${table.nameUpperCaseCamel}Dto dto){
        String  sql = "SELECT * FROM " + TABLE + createWhere(dto);
        return selectEs(conn, sql, ${table.nameUpperCaseCamel}Dto.class);
    }

    public PageData<${table.nameUpperCaseCamel}Dto> page(){
        return null;
    }

    public PageData<${table.nameUpperCaseCamel}Dto> page(${table.nameUpperCaseCamel}Dto dto){
        return null;
    }

    private String createWhere(${table.nameUpperCaseCamel}Dto dto){
        StringBuilder where = new StringBuilder(" WHERE is_delete = 'NO'");
        if (dto==null){
            dto = new ${table.nameUpperCaseCamel}Dto();
        }

        //criterias
        <#--
        * 以下类型不可用于对比
        * String : LONGTEXT,MEDIUMTEXT,TEXT
        * Byte[] : BINARY,BLOB,GEOMETRY,LONGBLOB,MEDIUMBLOB,TINYBLOB,VARBINARY
        -->
        <#list table.columns as column>
        <#if column.typeName != "LONGTEXT" && column.typeName != "MEDIUMTEXT" && column.typeName != "TEXT" && column.typeName != "BINARY" && column.typeName != "BLOB" && column.typeName != "GEOMETRY" && column.typeName != "LONGBLOB" && column.typeName != "MEDIUMBLOB" && column.typeName != "TINYBLOB" && column.typeName != "VARBINARY">
        if (dto.get${column.nameUpperCaseCamel}()!=null){
            where.append(" AND ${column.nameUnderLine} = "+ dto.get${column.nameUpperCaseCamel}());
        }
        </#if>
        </#list>

        // BASE
        if ( dto.getTimeFrom() != null ) {
            where.append(" AND date_created >= '").append(DateUtil.getYyyyDdMmHhMmSs(dto.getTimeFrom())).append("'");
        }
        if ( dto.getTimeTo() != null ) {
            where.append(" AND date_created <= '").append(DateUtil.getYyyyDdMmHhMmSs(dto.getTimeTo())).append("'");
        }
        return where.toString();
    }

}
