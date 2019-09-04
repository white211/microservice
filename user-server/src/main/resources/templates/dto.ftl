package ${dto.packagePath};

import com.fasterxml.jackson.annotation.JsonInclude;
import ${model.packagePath}.${table.nameUpperCaseCamel};
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: Create by Shrimp Generator
 * @author: wangkaicun @ current time
 * @table: ${table.nameUnderLine} (${table.remarks?if_exists})
 */

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ${table.nameUpperCaseCamel}Dto extends ${table.nameUpperCaseCamel} {

}
