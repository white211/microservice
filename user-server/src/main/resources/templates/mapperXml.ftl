  <insert id="insertBatch" parameterType="map">
    insert into ${table.nameUnderLine}
    <trim prefix="(" suffix=")" suffixOverrides=",">
      <#list table.columns as column>
      <if test="columnsMap.${column.nameLowwerCaseCamel} != null">
        ${column.nameUnderLine},
      </if>
      </#list>
    </trim>
    values
    <foreach collection = "record" item = "item" separator = ",">
      <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list table.columns as column>
        <if test="columnsMap.${column.nameLowwerCaseCamel} != null">
          \#\{item.${column.nameLowwerCaseCamel}\},
        </if>
        </#list>
      </trim>
    </foreach>
  </insert>