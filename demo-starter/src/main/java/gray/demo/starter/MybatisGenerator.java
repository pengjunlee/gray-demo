package gray.demo.starter;

import gray.bingo.mybatis.generator.BingoGenerator;
import gray.bingo.mybatis.generator.BingoGeneratorConfig;

public class MybatisGenerator {

    public static void main(String[] args) {
        // 数据库url
        final String DB_URL = "jdbc:mysql://192.168.2.2:3306/blossom?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=Asia/Shanghai";
        // 数据库用户名
        final String USERNAME = "root";
        // 数据库密码
        final String PASSWORD = "123456";
        // 需要生成代码的数据表
        String[] tableNames = {"base_user"};
        BingoGeneratorConfig generatorConfig = BingoGeneratorConfig.build4MultiModule()
                .dataSource(DB_URL, USERNAME, PASSWORD)
                .author("二月菌")
                .entity("demo-common", "gray.demo.common.entity")
                .mapper("demo-infrastructure", "gray.demo.infrastructure.mapper")
                .service("demo-infrastructure", "gray.demo.infrastructure.repo", "demo-infrastructure", "gray.demo.infrastructure.repo.impl","Repo")
                .controller("demo-adapter", "gray.demo.adapter.controller")
                .build();

//        BingoPlusConfig generatorConfig = BingoPlusConfig.build4SingleModule()
//                .author("二月菌")
//                .enableSwagger(false)
//                .packageName("gray.demo.infrastructure")
//                .enableService(true)
//                .enableController(true)
//                .build();
        BingoGenerator.generate(tableNames, generatorConfig);
    }
}
