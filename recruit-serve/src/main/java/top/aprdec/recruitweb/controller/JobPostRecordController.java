package top.aprdec.recruitweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aprdec.recruitweb.DTO.JobRecordDTO;
import top.aprdec.recruitweb.mapper.JobPostRecordMapper;
import top.aprdec.recruitweb.pojo.JobPostRecord;
import top.aprdec.recruitweb.pojo.ResultData;
import top.aprdec.recruitweb.pojo.User;
import top.aprdec.recruitweb.service.JobPostRecordService;
import top.aprdec.recruitweb.service.UserService;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
public class JobPostRecordController {
    @Autowired
    UserService userService;
    @Autowired
    JobPostRecordService jobPostRecordService;
    @Autowired
    JobPostRecordMapper jobPostRecordMapper;

    @GetMapping("/list")
    public ResultData getListbyownId(){
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer id = (int) claims.get("id");
        String role = (String) claims.get("role");
        if (role.equals("employee")){
            List<JobRecordDTO> list = jobPostRecordMapper.employeegetParseRecordList(id);
            System.out.println(list);
            return ResultData.success(list);
        }
        if(role.equals("employer")){
            List<JobRecordDTO> list = jobPostRecordMapper.employergetParseRecordList(id);
            return ResultData.success(list);
        }
        if(role.equals("admin")){
            List<JobPostRecord> list = jobPostRecordService.list();
            return ResultData.success(list);
        }
        return ResultData.error("查询失败");
    }
}
