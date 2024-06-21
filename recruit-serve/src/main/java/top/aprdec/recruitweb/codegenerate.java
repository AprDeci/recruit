package top.aprdec.recruitweb;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class codegenerate {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.17.1:32768/RecruitmentPlatform?useSSL=false&serverTimezone=UTC","root","Luchen1122")
                .globalConfig(builder ->
                        builder.author("aprdec")
                                .outputDir("D:\\ECLIpse\\workspace\\recruit-web\\src\\main\\java")
                                .commentDate("yyyy-MM-dd hh:mm:ss")
                                .disableOpenDir()
                )
                .packageConfig(builder ->
                        builder.parent("top.aprdec.recruitweb")
                                .entity("pojo")
                                .service("service")
                                .serviceImpl("service.impl")
                                .mapper("mapper")
                                .xml("mapper.xml")

                )
                .strategyConfig(builder -> {
                    builder.addTablePrefix("sys_") // 设置过滤表前缀
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .enableFileOverride() // 覆盖已生成文件
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            // Service 策略配置
                            .serviceBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            // Controller 策略配置
                            .controllerBuilder()
                    ;
                })
                .execute();

    }
}
