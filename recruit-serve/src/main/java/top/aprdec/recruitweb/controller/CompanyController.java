package top.aprdec.recruitweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import top.aprdec.recruitweb.DTO.CompanyWithJobsDTO;
import top.aprdec.recruitweb.mapper.CompanyMapper;
import top.aprdec.recruitweb.mapper.EmployerMapper;
import top.aprdec.recruitweb.mapper.JobPostingMapper;
import top.aprdec.recruitweb.pojo.Company;
import top.aprdec.recruitweb.pojo.JobPosting;
import top.aprdec.recruitweb.pojo.ResultData;
import top.aprdec.recruitweb.service.CompanyService;
import top.aprdec.recruitweb.service.EmployerService;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author aprdec
 * @since 2024-06-11 11:03:10
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    EmployerService employerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    EmployerMapper employerMapper;

    @GetMapping("/info")
    public ResultData Companyinfo(){
        Map<String,Object> claims= ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        Company company=employerMapper.getCompanyByuid(id);
        return ResultData.success(company);

    }

    @GetMapping("/randomlistwithjobs")
    public ResultData randomlistwithjobs(){
        List<CompanyWithJobsDTO> list=companyService.getCompanyWithJobs();
        return ResultData.success(list);
    }

    @GetMapping("/list/{num}")
    public ResultData list(@PathVariable("num") int num){
        List<Company> list = companyService.list();
        if (num==0){
            return ResultData.success(list);
        }
        list = list.subList(0, num);
        return ResultData.success(list);
    }

    @GetMapping("/info/{companyid}")
    public ResultData info(@PathVariable("companyid") int companyid){
        Company company = companyService.getById(companyid);
        return ResultData.success(company);

    }
}
