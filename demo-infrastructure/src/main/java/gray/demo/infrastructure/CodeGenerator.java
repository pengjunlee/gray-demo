package gray.demo.infrastructure;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MK
 * @date 2022/4/21
 */
public class CodeGenerator {

    private static GeneratorConfig generatorConfig;

    private static void setGeneratorConfig(GeneratorConfig generatorConfig) {
        CodeGenerator.generatorConfig = generatorConfig;
    }

    private static class GeneratorConfig {

        /**
         * 项目路径
         */
        private static final String PARENT_DIR = System.getProperty("user.dir");

        private static final String FILE_SEPARATOR = "/";

        /**
         * 源代码基本路径
         */
        private static final String SRC_MAIN_JAVA = "/src/main/java/";

        /**
         * 资源文件基本路径
         */
        private static final String SRC_MAIN_RESOURCES = "/src/main/resources/";

        private boolean multiModule;

        /**
         * 作者
         */
        private String AUTHOR;

        /**
         * 启用swagger注解
         */
        private boolean ENABLE_SWAGGER;

        /**
         * 基础模块名
         */
        private String BASE_MODULE_NAME;

        /**
         * 基础包名
         */
        private String BASE_PACKAGE_NAME;

        /**
         * entity类存放模块
         */
        private String ENTITY_MODULE_NAME;

        /**
         * entity类包名
         */
        private String ENTITY_PACKAGE_NAME;

        /**
         * mapper类存放模块
         */
        private String MAPPER_MODULE_NAME;

        /**
         * mapper类包名
         */
        private String MAPPER_PACKAGE_NAME;

        /**
         * service类存放模块
         */
        private String SERVICE_MODULE_NAME;

        /**
         * mapper类包名
         */
        private String SERVICE_PACKAGE_NAME;

        /**
         * service实现类存放模块
         */
        private String SERVICE_IMPL_MODULE_NAME;

        /**
         * service实现类包名
         */
        private String SERVICE_IMPL_PACKAGE_NAME;

        /**
         * controller类存放模块
         */
        private String CONTROLLER_MODULE_NAME;

        /**
         * controller类包名
         */
        private String CONTROLLER_PACKAGE_NAME;

        private GeneratorConfig() {
            super();
        }

        /**
         * @param author        作者
         * @param packageName   包名
         * @param enableSwagger 启用swagger注解
         * @return GeneratorConfig
         */
        public static GeneratorConfig createForSingleModule(String author, boolean enableSwagger, String moduleName, String packageName) {
            GeneratorConfig config = new GeneratorConfig();
            config.AUTHOR = author;
            config.multiModule = false;
            config.BASE_MODULE_NAME = moduleName;
            config.BASE_PACKAGE_NAME = packageName;
            config.ENABLE_SWAGGER = enableSwagger;
            return config;
        }

        /**
         * @param author                 作者
         * @param enableSwagger          启用swagger注解
         * @param entityModuleName       实体类模块名
         * @param entityPackageName      实体类包名名
         * @param mapperModuleName       Mapper类模块名
         * @param mapperPackageName      Mapper类包名名
         * @param serviceModuleName      service接口类模块名
         * @param servicePackageName     service接口类包名名
         * @param serviceImplModuleName  service实现类模块名
         * @param serviceImplPackageName service实现类包名名
         * @param controllerModuleName   controller类模块名
         * @param controllerPackageName  controller类包名名
         * @return GeneratorConfig
         */
        public static GeneratorConfig createForMultiModule(String author, boolean enableSwagger,
                                                           String entityModuleName, String entityPackageName,
                                                           String mapperModuleName, String mapperPackageName,
                                                           String serviceModuleName, String servicePackageName,
                                                           String serviceImplModuleName, String serviceImplPackageName,
                                                           String controllerModuleName, String controllerPackageName) {
            GeneratorConfig config = new GeneratorConfig();
            config.AUTHOR = author;
            config.multiModule = true;
            config.ENABLE_SWAGGER = enableSwagger;
            config.ENTITY_MODULE_NAME = entityModuleName;
            config.ENTITY_PACKAGE_NAME = entityPackageName;
            config.MAPPER_MODULE_NAME = mapperModuleName;
            config.MAPPER_PACKAGE_NAME = mapperPackageName;
            config.SERVICE_MODULE_NAME = serviceModuleName;
            config.SERVICE_PACKAGE_NAME = servicePackageName;
            config.SERVICE_IMPL_MODULE_NAME = serviceImplModuleName;
            config.SERVICE_IMPL_PACKAGE_NAME = serviceImplPackageName;
            config.CONTROLLER_MODULE_NAME = controllerModuleName;
            config.CONTROLLER_PACKAGE_NAME = controllerPackageName;
            return config;
        }

        /**
         * xml文件存放路径
         */
        private String xmlPath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + MAPPER_MODULE_NAME + SRC_MAIN_RESOURCES + "mappers";
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_RESOURCES + "mappers";
        }

        /**
         * entity文件存放路径
         */
        private String entityPath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + ENTITY_MODULE_NAME + FILE_SEPARATOR + SRC_MAIN_JAVA + ENTITY_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR);
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_JAVA + BASE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR) + FILE_SEPARATOR + "entity";
        }

        /**
         * mapper文件存放路径
         */
        private String mapperPath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + MAPPER_MODULE_NAME + FILE_SEPARATOR + SRC_MAIN_JAVA + MAPPER_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR);
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_JAVA + BASE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR) + FILE_SEPARATOR + "dao";
        }

        /**
         * service文件存放路径
         */
        private String servicePath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + SERVICE_MODULE_NAME + FILE_SEPARATOR + SRC_MAIN_JAVA + SERVICE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR);
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_JAVA + BASE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR) + FILE_SEPARATOR + "service";
        }

        /**
         * mapper文件存放路径
         */
        private String serviceImplPath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + SERVICE_IMPL_MODULE_NAME + FILE_SEPARATOR + SRC_MAIN_JAVA + SERVICE_IMPL_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR);
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_JAVA + BASE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR) + FILE_SEPARATOR + "service/impl";
        }

        /**
         * controller文件存放路径
         */
        private String controllerPath() {
            if (multiModule) {
                return PARENT_DIR + FILE_SEPARATOR + CONTROLLER_MODULE_NAME + FILE_SEPARATOR + SRC_MAIN_JAVA + CONTROLLER_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR);
            }
            return PARENT_DIR + FILE_SEPARATOR + BASE_MODULE_NAME + SRC_MAIN_JAVA + BASE_PACKAGE_NAME.replaceAll("\\.", FILE_SEPARATOR) + FILE_SEPARATOR + "controller";
        }


        /**
         * entity文件包名
         */
        private String entityPackage() {
            if (multiModule) {
                return ENTITY_PACKAGE_NAME;
            }
            return BASE_PACKAGE_NAME + ".entity";
        }

        /**
         * mapper文件存放路径
         */
        private String mapperPackage() {
            if (multiModule) {
                return MAPPER_PACKAGE_NAME;
            }
            return BASE_PACKAGE_NAME + ".dao";
        }

        /**
         * service文件存放路径
         */
        private String servicePackage() {
            if (multiModule) {
                return SERVICE_PACKAGE_NAME;
            }
            return BASE_PACKAGE_NAME + ".service";
        }

        /**
         * mapper文件存放路径
         */
        private String serviceImplPackage() {
            if (multiModule) {
                return SERVICE_IMPL_PACKAGE_NAME;
            }
            return BASE_PACKAGE_NAME + ".serviceImpl";
        }

        /**
         * controller文件存放路径
         */
        private String controllerPackage() {
            if (multiModule) {
                return CONTROLLER_PACKAGE_NAME;
            }
            return BASE_PACKAGE_NAME + ".controller";
        }
    }


    public static void generate(DataSourceConfig.Builder dataSourceConfig, String[] tablesNames, GeneratorConfig generatorConfig) {

        CodeGenerator.setGeneratorConfig(generatorConfig);


        FastAutoGenerator.create(dataSourceConfig)
                // 全局配置
                .globalConfig(builder -> {
                            builder.author(generatorConfig.AUTHOR)
                                    .disableOpenDir()
                                    .dateType(DateType.ONLY_DATE)
                                    .commentDate("yyyy-MM-dd HH:mm:ss");
                            if (generatorConfig.ENABLE_SWAGGER) {
                                builder.enableSwagger();
                            }
                        }
                )
                // 包配置
                .packageConfig(builder -> builder
                        .parent("")
                        .xml("mappers")
                        .entity(generatorConfig.entityPackage())
                        .mapper(generatorConfig.mapperPackage())
                        .service(generatorConfig.servicePackage())
                        .serviceImpl(generatorConfig.serviceImplPackage())
                        .controller(generatorConfig.controllerPackage())
                        .pathInfo(getPathInfo())
                )
                // 策略配置
                .strategyConfig(builder -> builder
                        .addInclude(tablesNames)
                        // entity
                        .entityBuilder()
                        .fileOverride()
                        .enableChainModel()
                        .enableLombok()
                        .enableRemoveIsPrefix()
                        .logicDeleteColumnName("is_delete")
                        .idType(IdType.ASSIGN_ID)
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                        // controller
                        .controllerBuilder()
                        .fileOverride()
                        .enableRestStyle()
                        .formatFileName("%sController")
                        // service
                        .serviceBuilder()
                        .fileOverride()
                        .superServiceClass(IService.class)
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImp")
                        // mapper
                        .mapperBuilder()
                        .fileOverride()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .superClass(BaseMapper.class)
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
                        .enableMapperAnnotation()
                )
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 获取路径信息map
     *
     * @return {@link Map< OutputFile, String> }
     * @author MK
     * @date 2022/4/21 21:21
     */
    private static Map<OutputFile, String> getPathInfo() {
        Map<OutputFile, String> pathInfo = new HashMap<>(5);
        pathInfo.put(OutputFile.entity, generatorConfig.entityPath());
        pathInfo.put(OutputFile.mapper, generatorConfig.mapperPath());
        pathInfo.put(OutputFile.service, generatorConfig.servicePath());
        pathInfo.put(OutputFile.serviceImpl, generatorConfig.serviceImplPath());
        pathInfo.put(OutputFile.controller, generatorConfig.controllerPath());
        pathInfo.put(OutputFile.xml, generatorConfig.xmlPath());
        return pathInfo;
    }

    public static void main(String[] args) {
        /**
         * 数据库url
         */
        final String DB_URL = "jdbc:mysql://192.168.2.2:3306/blossom?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=Asia/Shanghai";
        /**
         * 数据库用户名
         */
        final String USERNAME = "root";
        /**
         * 数据库密码
         */
        final String PASSWORD = "123456";
        DataSourceConfig.Builder builder = new DataSourceConfig.Builder(DB_URL, USERNAME, PASSWORD);
        String[] tableNames = {"base_user"};
        // GeneratorConfig generatorConfig = GeneratorConfig.createForSingleModule("二月菌", false, "demo-infrastructure", "gray.demo.infrastructure");
        GeneratorConfig generatorConfig = GeneratorConfig.createForMultiModule("二月菌", false,
                "demo-common", "gray.demo.common.entity", "demo-infrastructure", "gray.demo.infrastructure.dao",
                "demo-api", "gray.demo.api.service", "demo-api-impl", "gray.demo.apiImpl.service",
                "demo-adapter", "gray.demo.adapter.controller"
        );
        generate(builder, tableNames, generatorConfig);

    }
}