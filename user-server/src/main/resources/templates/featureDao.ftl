package ${featureDao.packagePath};

import ${project.commonLib}.base.BaseMapper;
import ${model.packagePath}.${table.nameUpperCaseCamel};
import ${model.packagePath}.${table.nameUpperCaseCamel}Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ${table.nameUpperCaseCamel}Mapper extends BaseMapper<${table.nameUpperCaseCamel}, ${table.nameUpperCaseCamel}Example> {

    // 示例查询
    List<${table.nameUpperCaseCamel}> selectExample(${table.nameUpperCaseCamel} model);

}
