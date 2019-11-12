package ${cfg.packageInfo.Entity};

import lombok.Data;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
/**
 * Description: Create by mybatis-plus Generator
 * @author: white @ current time
 */
@Data
public class ${table.entityName} extends Model<${table.entityName}>{

   <#list table.fields as TableField>

      // ${TableField.comment}
      <#if TableField.name == 'id'>
      @TableId(value = "id", type = IdType.AUTO)
      </#if>
      <#if TableField.columnType == "INTEGER">
       private Integer ${TableField.propertyName};
      </#if>
      <#if TableField.columnType == "STRING">
       private String ${TableField.propertyName};
      </#if>
      <#if TableField.columnType == "LOCAL_DATE_TIME">
       private Date ${TableField.propertyName};
      </#if>
   </#list>


}
