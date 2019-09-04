package ${repo.packagePath};

import ${project.commonLib}.base.BaseRepo;
import ${project.commonLib}.base.PageData;
import ${model.packagePath}.${table.nameUpperCaseCamel};
import org.springframework.stereotype.Component;

/**
 * Description:  Create by Shrimp Generator
 * @author: wangkaicun  @ current time
 */
@Component
public interface ${table.nameUpperCaseCamel}Repo extends BaseRepo<${table.nameUpperCaseCamel}> {

    // 示例查询
    PageData<${table.nameUpperCaseCamel}> selectExample(${table.nameUpperCaseCamel} model);

}
