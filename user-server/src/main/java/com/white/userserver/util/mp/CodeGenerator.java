package com.white.userserver.util.mp;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

/**
 * @Program: CodeGenerator
 * @Description:
 * @Author: White
 * @DateTime: 2019-04-28 11:08:29
 **/

public class CodeGenerator  {

    private static String packageName="userserver";    //文件路径
    private static String authorName="White";     //作者
    private static String table="tb_user";                  //table名字
    //    private static String prefix="sc_";                     //table前缀
    private static File file = new File("");
    private static String path = file.getAbsolutePath()+"/user-server/";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }



    public static void main(String[] args) {


        List<FileOutConfig> fileOutConfigs = new ArrayList<>();

        FileOutConfig fileOutConfig = new FileOutConfig("/templates/mapper.xml.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+"/src/main/resources/mybatis/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        };

        FileOutConfig fileOutConfig111 = new FileOutConfig("/templates/controller.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+"/src/main/java/com/white/userserver/controller/core/" + tableInfo.getEntityName() + "Controller.java";
            }
        };

        FileOutConfig fileOutConfig222 = new FileOutConfig("/templates/dto.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+"/src/main/java/com/white/userserver/pojo/dto/" + tableInfo.getEntityName() + "DTO.java";
            }
        };

        fileOutConfigs.add(fileOutConfig);
        fileOutConfigs.add(fileOutConfig111);
        fileOutConfigs.add(fileOutConfig222);

        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(path+"/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setOpen(false)//生成后打开文件夹
                        .setAuthor(authorName)
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        .setMapperName("%sMapper")
                        .setXmlName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            public IColumnType processTypeConvert(String fieldType) {
                                GlobalConfig globalconfig = new GlobalConfig();
                                System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(globalconfig,fieldType);
                            }
                        })
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUsername("root")
                        .setPassword("root")
                        .setUrl("jdbc:mysql://localhost:3306/microservice?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)//全局下划线命名
//                        .setTablePrefix(new String[]{prefix})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(scanner("表名"))
//                        .setInclude(new String[] { table }) // 需要生成的表
                        .setRestControllerStyle(true)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        //.setSuperEntityColumns(new String[]{"test_id"})
                        .setTableFillList(tableFillList)
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
//                        .setSuperControllerClass("com.naswork."+packageName+".controller.AbstractController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                // .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
//                        .setModuleName(scanner("模块名"))
                        .setParent("com.white."+packageName)// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
                        .setEntity("pojo.entity")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                //.setXml("mapper")
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-自定义属性配置");
                        //tableInfo
                        map.put("table",this.getConfig().getTableInfoList().get(0));
                        //packageInfo
                        map.put("packageInfo",this.getConfig().getPackageInfo());
                        //pathInfo
                        map.put("pathInfo",this.getConfig().getPathInfo());
                        //controllerPackage
                        String controllerPath = this.getConfig().getPackageInfo().get("Controller");
                        map.put("controllerPath",controllerPath+".core");
                        //pathUrl
                        String pathUrl = "com.white."+packageName;
                        map.put("pathUrl",pathUrl);
                        //数据表名驼峰式
                        String tabelName = this.getConfig().getTableInfoList().get(0).getEntityName();
                        String S1 = tabelName.substring(0,1);
                        String s1 = S1.toLowerCase();
                        String nameLowwerCaseCamel = s1+tabelName.substring(1);
                        map.put("nameLowwerCaseCamel",nameLowwerCaseCamel);
                        //dto路径设置
                        String entityUrl = this.getConfig().getPackageInfo().get("Entity");
                        String  pojoUrl = entityUrl.substring(0,entityUrl.lastIndexOf("."));
                        map.put("dtoPath",pojoUrl+".dto");
                        //数据表字段转驼峰式

                        this.setMap(map);
                    }
                }
                .setFileOutConfigList(fileOutConfigs)
//                .setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
//                    // 自定义输出文件目录
//                    @Override
//                    public String outputFile(TableInfo tableInfo) {
//                        return path+"/src/main/resources/mybatis/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
//                    }
//                }))
//                .setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/controller.java.ftl") {
//                    // 自定义输出文件目录
//                    @Override
//                    public String outputFile(TableInfo tableInfo) {
//                        return path+"/src/main/java/com/white/userserver/controller/core/" + tableInfo.getEntityName() + "Controller.java";
//                    }
//                }))
//                .setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/dto.java.ftl") {
//                    // 自定义输出文件目录
//                    @Override
//                    public String outputFile(TableInfo tableInfo) {
//                        return path+"/src/main/java/com/white/userserver/pojo/dto/" + tableInfo.getEntityName() + "DTO.java";
//                    }
//        }))
        ).setTemplate(
                new TemplateConfig()
                // 关闭默认 xml 生成，调整生成 至 根目录
                .setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                 .setController(null)
//                 .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );

        //设置引擎模板
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 执行生成
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        // System.err.println(mpg.getCfg().getMap().get("abc"));

        System.err.println(mpg.getCfg().getMap().get("packageInfo"));
        System.err.println(mpg.getCfg().getMap().get("pathInfo"));
        System.err.println(mpg.getCfg().getMap().get("table"));

    }


}
