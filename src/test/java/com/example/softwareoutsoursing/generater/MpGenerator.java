package com.example.softwareoutsoursing.generater;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MpGenerator {

    private static String absolutePath = "D:\\JAVA\\SoftwareOutsoursing\\src\\main\\java"; // 绝对路径(生成代码放置位置 - 你自己的)
    private static String packageName= "com.example.softwareoutsoursing"; // 包名
    private static String tableName = "employee,preferences,schedulingrules,store,user"; // 生成的表名称|  生成多张表代码,输入格式为"t1,t2,t3"(逗号分隔); 需要生成所有表代码,这里设置为空; 单表,输入指定表名 "

    // 注: tinyInt1isBit=false这个不加的话, 如果你的数据库字段类型为tinyint(1)转成java实体类字段会变成boolean,而不是int
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/a33?useUnicode=true&characterEncoding=utf-8&tinyInt1isBit=false&useSSL=false";
    private static String jdbcDriverName = "com.mysql.cj.jdbc.Driver";
    private static String jdbcRoot = "root";
    private static String jdbcPassWord = "";

    // other
    private static String author = "XYZ"; // 作者名称
    private static String modelName= "entity"; // 实体类所在文件夹名称(根据个人习惯)
    private static String daoName= "mapper"; // mapper接口所在文件夹名称(根据个人习惯)

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(absolutePath);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setBaseResultMap(true); // mapper.xml生成resultMap
        gc.setBaseColumnList(true); // mapper.xml 生成 ColumnList
        gc.setSwagger2(false); // 实体属性 Swagger2 注解
        gc.setFileOverride(false); // 新生成文件是否覆盖已有文件
        gc.setEnableCache(false); // 是否开启二级缓存
        gc.setServiceName("%sService");  // 设置生成的service接口的名字的首字母是否为I
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(jdbcDriverName);
        dsc.setUsername(jdbcRoot);
        dsc.setPassword(jdbcPassWord);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setMapper(daoName);
        pc.setEntity(modelName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

//        String templatePath = "/templates/mapper.xml.ftl"; // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.vm"; // 如果模板引擎是 velocity

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String replace = packageName.replace(".", "\\");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return absolutePath + "/"+ replace+  "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableName.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
