<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${featureDao.packagePath}.${table.nameUpperCaseCamel}Mapper">

  <!-- // 示例查询 -->
  <select id="selectExample" parameterType="${model.packagePath}.${table.nameUpperCaseCamel}" resultType="${model.packagePath}.${table.nameUpperCaseCamel}">
    select
      <#list table.columns as column>
      ${column.nameUnderLine},
      </#list>
      'true' as QUERYID
    FROM
      ${table.nameUnderLine}
    WHERE
      1 = 1
      <#list table.columns as column>
      <if test="${column.nameLowwerCaseCamel} != null">
        AND ${column.nameUnderLine} = ${"#"}${"{"}${column.nameLowwerCaseCamel}${"}"}
      </if>
      </#list>
  </select>

</mapper>
