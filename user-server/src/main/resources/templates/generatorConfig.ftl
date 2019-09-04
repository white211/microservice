<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<!-- 配置参考：http://www.jianshu.com/p/e09d2370b796 -->
<generatorConfiguration>

    <!-- 引入配置文件 -->
    <!--
    <properties resource="config/application-generator.properties"/>
    -->

    <!-- 指定数据连接驱动jar地址 -->
    <classPathEntry location="${dataBase.driverJarPath}" />

    <!-- 一个数据库一个context -->
    <context id="master" targetRuntime="MyBatis3" defaultModelType="flat">

        <commentGenerator>
            <!-- 是否取消注释 -->
            <property name="suppressAllComments" value="true"/>
            <!-- 是否生成注释代时间戳-->
            <property name="suppressDate" value="true" />
        </commentGenerator>

        <!-- jdbc连接 -->
        <jdbcConnection driverClass="${dataBase.driverClass}"
                        connectionURL="${dataBase.connectionURLTransference}"
                        userId="${dataBase.username}"
                        password="${dataBase.password}">
        </jdbcConnection>

        <!-- 类型转换 -->
        <javaTypeResolver>
            <!-- 是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.） -->
            <property name="forceBigDecimals" value="true" />
        </javaTypeResolver>

        <!-- 生成实体类地址 -->
        <javaModelGenerator targetPackage="${model.packagePath}" targetProject="${model.project}">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.xxx.model， true:com.xxx.model.[schemaName] -->
            <property name="enableSubPackages" value="true" />
            <!-- 是否针对string类型的字段在set的时候进行trim调用 -->
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <!-- 生成mapxml文件 -->
        <sqlMapGenerator targetPackage="${mapperXml.packagePath}" targetProject="${mapperXml.project}">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.xxx.model， true:com.xxx.model.[schemaName] -->
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>

        <!-- 生成mapxml对应client，也就是接口dao -->
        <javaClientGenerator targetPackage="${dao.packagePath}" type="XMLMAPPER" targetProject="${dao.project}">
            <!-- 是否在当前路径下新加一层schema,eg：fase路径com.xxx.model， true:com.xxx.model.[schemaName] -->
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>


        <!-- 选择一个table来生成相关文件，可以有一个或多个table，必须要有table元素
            选择的table会生成一下文件：
            1，SQL map文件
            2，生成一个主键类；
            3，除了BLOB和主键的其他字段的类；
            4，包含BLOB的类；
            5，一个用户生成动态查询的条件类（selectByExample, deleteByExample），可选；
            6，Mapper接口（可选）

            tableName（必要）：要生成对象的表名；
            注意：大小写敏感问题。正常情况下，MBG会自动的去识别数据库标识符的大小写敏感度，在一般情况下，MBG会
                根据设置的schema，catalog或tablename去查询数据表，按照下面的流程：
                1，如果schema，catalog或tablename中有空格，那么设置的是什么格式，就精确的使用指定的大小写格式去查询；
                2，否则，如果数据库的标识符使用大写的，那么MBG自动把表名变成大写再查找；
                3，否则，如果数据库的标识符使用小写的，那么MBG自动把表名变成小写再查找；
                4，否则，使用指定的大小写格式查询；
            另外的，如果在创建表的时候，使用的""把数据库对象规定大小写，就算数据库标识符是使用的大写，在这种情况下也会使用给定的大小写来创建表名；
            这个时候，请设置delimitIdentifiers="true"即可保留大小写格式；

            可选：
                1，schema：数据库的schema；
                2，catalog：数据库的catalog；
                3，alias：为数据表设置的别名，如果设置了alias，那么生成的所有的SELECT SQL语句中，列名会变成：alias_actualColumnName
                4，domainObjectName：生成的domain类的名字，如果不设置，直接使用表名作为domain类的名字；可以设置为somepck.domainName，那么会自动把domainName类再放到somepck包里面；
                5，enableInsert（默认true）：指定是否生成insert语句；
                6，enableSelectByPrimaryKey（默认true）：指定是否生成按照主键查询对象的语句（就是getById或get）；
                7，enableSelectByExample（默认true）：MyBatis3Simple为false，指定是否生成动态查询语句；
                8，enableUpdateByPrimaryKey（默认true）：指定是否生成按照主键修改对象的语句（即update)；
                9，enableDeleteByPrimaryKey（默认true）：指定是否生成按照主键删除对象的语句（即delete）；
                10，enableDeleteByExample（默认true）：MyBatis3Simple为false，指定是否生成动态删除语句；
                11，enableCountByExample（默认true）：MyBatis3Simple为false，指定是否生成动态查询总条数语句（用于分页的总条数查询）；
                12，enableUpdateByExample（默认true）：MyBatis3Simple为false，指定是否生成动态修改语句（只修改对象中不为空的属性）；
                13，modelType：参考context元素的defaultModelType，相当于覆盖；
                14，delimitIdentifiers：参考tableName的解释，注意，默认的delimitIdentifiers是双引号，如果类似MYSQL这样的数据库，使用的是`（反引号，那么还需要设置context的beginningDelimiter和endingDelimiter属性）
                15，delimitAllColumns：设置是否所有生成的SQL中的列名都使用标识符引起来。默认为false，delimitIdentifiers参考context的属性

            注意，table里面很多参数都是对javaModelGenerator，context等元素的默认属性的一个复写；
         -->

        <!-- 配置表信息 -->
        <#list dataBase.tables as table>
        <table schema="${dataBase.dataBaseName}"
               tableName="${table.nameUnderLine}"
               enableInsert="true"
               enableSelectByPrimaryKey="true"
               enableSelectByExample="true"
               enableUpdateByPrimaryKey="true"
               enableDeleteByPrimaryKey="false"
               enableDeleteByExample="false"
               enableCountByExample="true"
               enableUpdateByExample="true">
            <generatedKey column="id" sqlStatement="MySql" identity="true"/>
        </table>
        </#list>
    </context>

</generatorConfiguration>