package top.aprdec.recruitweb;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForReadableInstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.aprdec.recruitweb.DTO.EmployeeDTO;
import top.aprdec.recruitweb.mapper.JobPostRecordMapper;
import top.aprdec.recruitweb.mapper.UserMapper;
import top.aprdec.recruitweb.pojo.JobPosting;
import top.aprdec.recruitweb.pojo.User;
import top.aprdec.recruitweb.service.JobPostingService;
import top.aprdec.recruitweb.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RecruitWebApplication.class})
public class SpringdocMybatisApplicationTests {
    @Autowired
    JobPostRecordMapper jobPostRecordMapper;
    @Autowired
    private PastValidatorForReadableInstant pastValidatorForReadableInstant;

    @Test
    public void contextLoads() {
        System.out.println(jobPostRecordMapper.employeegetParseRecordList(2));
    }

}
