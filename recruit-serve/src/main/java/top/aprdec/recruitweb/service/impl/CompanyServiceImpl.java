package top.aprdec.recruitweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.aprdec.recruitweb.DTO.CompanyWithJobsDTO;
import top.aprdec.recruitweb.mapper.JobPostingMapper;
import top.aprdec.recruitweb.pojo.Company;
import top.aprdec.recruitweb.mapper.CompanyMapper;
import top.aprdec.recruitweb.pojo.JobPosting;
import top.aprdec.recruitweb.pojo.ResultData;
import top.aprdec.recruitweb.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
    @Autowired
    JobPostingMapper jobPostingMapper;
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<CompanyWithJobsDTO> getCompanyWithJobs() {
        List<CompanyWithJobsDTO> resultList=new ArrayList<>();
        //        查询9个公司
        List<Company> list = companyMapper.getRandomCompanies(9);
//        循环查询3个工作
        for (Company company : list){
            List< JobPosting> joblists =jobPostingMapper.getJobListByRandomByCompanyid(company.getId(),3);
            resultList.add(new CompanyWithJobsDTO(company,joblists));
        }
        return resultList;
    }
}
