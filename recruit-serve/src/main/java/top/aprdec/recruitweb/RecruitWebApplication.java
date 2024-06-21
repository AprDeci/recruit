package top.aprdec.recruitweb;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "top.aprdec.recruitweb.mapper",annotationClass = Mapper.class)
@SpringBootApplication
public class RecruitWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitWebApplication.class, args);
    }

}
