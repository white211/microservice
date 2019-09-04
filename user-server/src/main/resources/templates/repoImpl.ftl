package ${repoImpl.packagePath};

import ${project.commonLib}.base.PageData;
import ${project.commonLib}.base.impl.BaseRepoImpl;
import ${featureDao.packagePath}.${table.nameUpperCaseCamel}Mapper;
import ${model.packagePath}.${table.nameUpperCaseCamel};
import ${model.packagePath}.${table.nameUpperCaseCamel}Example;
import ${repo.packagePath}.${table.nameUpperCaseCamel}Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* Description:  Create by Shrimp Generator
* @author: wangkaicun  @ current time
*/
@Component
public class ${table.nameUpperCaseCamel}RepoImpl extends BaseRepoImpl<${table.nameUpperCaseCamel}, ${table.nameUpperCaseCamel}Example> implements ${table.nameUpperCaseCamel}Repo {

    private ${table.nameUpperCaseCamel}Mapper mapper;

    @Autowired
    private void setMapper(${table.nameUpperCaseCamel}Mapper mapper) {
        super.modelClazz = ${table.nameUpperCaseCamel}.class;
        super.mapper = mapper;
        this.mapper = mapper;
    }


    /**
    * 示例查询
    */
    @Override
    public PageData<${table.nameUpperCaseCamel}> selectExample(${table.nameUpperCaseCamel} model){
        pagePreHandle(model);
        List<${table.nameUpperCaseCamel}> dtos = mapper.selectExample(model);
        return pageSelect(model,dtos);
    }

}
