package top.aprdec.recruitweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.aprdec.recruitweb.mapper.JobPostRecordMapper;
import top.aprdec.recruitweb.mapper.JobPostingMapper;
import top.aprdec.recruitweb.pojo.JobPostRecord;
import top.aprdec.recruitweb.pojo.JobPosting;
import top.aprdec.recruitweb.service.JobPostRecordService;
import top.aprdec.recruitweb.service.JobPostingService;

@Service
public class JobPostRecordServiceImpl  extends ServiceImpl<JobPostRecordMapper, JobPostRecord> implements JobPostRecordService {
}
