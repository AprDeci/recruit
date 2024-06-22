package top.aprdec.recruitweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import top.aprdec.recruitweb.DTO.JobCompanyDTO;
import top.aprdec.recruitweb.DTO.PageDto;
import top.aprdec.recruitweb.mapper.JobPostingMapper;
import top.aprdec.recruitweb.pojo.Employer;
import top.aprdec.recruitweb.pojo.JobPosting;
import top.aprdec.recruitweb.pojo.ResultData;
import top.aprdec.recruitweb.service.JobPostingService;
import top.aprdec.recruitweb.util.DTOUtil;
import top.aprdec.recruitweb.util.JobTypeUtil;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

import javax.xml.transform.Result;
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
@RequestMapping("/jobPosting")
public class JobPostingController {
    @Autowired
    JobPostingService jobPostingService;
    @Autowired
    JobPostingMapper jobPostingMapper;

    @GetMapping("/list")
    public ResultData list(){
        Map<String,Object> claims= ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        String role = (String) claims.get("role");
        if(role.equals("employer")){
           List<JobPosting> list = jobPostingMapper.getJobListByuid(id);
           return ResultData.success(list);
        }

        if (role.equals("admin")) {
            List<JobPosting> jobs = jobPostingService.list();
            return ResultData.success(jobs);
        }
        return ResultData.error("权限不足");
    }

    @GetMapping("/list/{compnayid}")
    public ResultData list(Integer compnayid){
        QueryWrapper<JobPosting> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("compnayid", compnayid);
        List<JobPosting> jobs = jobPostingService.list(queryWrapper);
        return ResultData.success(jobs);
    }

    @PostMapping("/add")
    public ResultData add(JobPosting jobPosting){
        jobPostingService.save(jobPosting);
        return ResultData.success("添加成功");
    }

    @PostMapping("/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer id){
        jobPostingService.removeById(id);
        return ResultData.success("删除成功");
    }

    @PostMapping("/update")
    public ResultData update(JobPosting jobPosting){
        jobPostingService.updateById(jobPosting);
        return ResultData.success("更新成功");
    }

    @GetMapping("/listpage")
    public ResultData getListByPage(@RequestParam("size") int size,@RequestParam("page")int page,@RequestParam("eid")int eid){
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        String role = (String) map.get("role");
        QueryWrapper<JobPosting> wrapper = new QueryWrapper<>();
        wrapper.eq("employer_id",eid);
        IPage<JobPosting> Page=new Page<>(page,size);
        IPage<JobPosting> jobpage = jobPostingService.page(Page,wrapper);
        List<JobPosting> list = jobpage.getRecords();
        long total = jobpage.getTotal();
        return ResultData.success(new PageDto<>(total, list));

    }

    @GetMapping("/getrand/{limit}")
    public ResultData getListByRand(@PathVariable("limit")int limit){
        List<JobPosting> list = jobPostingMapper.getJobListByRandom(limit);
        return ResultData.success(list);
    }

    @GetMapping("/getjcDto")
    public ResultData JobCompanyDTOByrandom(@RequestParam("limit")int limit){
        List<JobCompanyDTO> list = jobPostingMapper.getJobAndCompanyByRandom(limit);
        DTOUtil.JobCompanyDTOinitst(list);
        return ResultData.success(list);
    }
    @GetMapping("/getjcDto/{id}")
    public ResultData JobCompanyDTOById(@PathVariable("id")int id){
        JobCompanyDTO jcdto = jobPostingMapper.getJobAndCompanyById(id);
        DTOUtil.JobCompanyDTOinitst(jcdto);
        return ResultData.success(jcdto);
    }
    @GetMapping("/gettypes/{companyId}")
    public ResultData gettypes(@PathVariable("companyId")int companyId){
        QueryWrapper<JobPosting> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_id", companyId).select("type");
//只查询jobposting的type属性
        List<JobPosting> list=jobPostingService.list(queryWrapper);
        List<String> types = list.stream().map(JobPosting::getType).distinct().toList();
        List<JobTypeUtil.JobType> result = JobTypeUtil.getJobTypeList(types,list);
        return ResultData.success(result);
    }

    @GetMapping("/getinfoBypageBycompanyid/{companyid}")
    public ResultData getinfoBypageByjobid(@PathVariable("companyid")int companyid,@RequestParam("size")int size,@RequestParam("page")int page){
        QueryWrapper<JobPosting> queryWrapper = new QueryWrapper<>();
        IPage<JobPosting> Page=new Page<>(page,size);
        queryWrapper.eq("company_id", companyid);
        IPage<JobPosting> jobpage = jobPostingService.page(Page,queryWrapper);
        List<JobPosting> list = jobpage.getRecords();
        long total = jobpage.getTotal();
        return ResultData.success(new PageDto<>(total, list));
    }
//    根据类型限制
    @GetMapping("/getinfoBypageBycompanyidBytype/{companyid}")
    public ResultData getinfoBypageByjobidBytype(@PathVariable("companyid")int companyid,@RequestParam("size")int size,@RequestParam("page")int page,@RequestParam("type")String type){
        QueryWrapper<JobPosting> queryWrapper = new QueryWrapper<>();
        IPage<JobPosting> Page=new Page<>(page,size);
        queryWrapper.eq("company_id", companyid);
        //        处理type转换为字符
        queryWrapper.eq("type",JobTypeUtil.getJobTypeByJobId(type));
        IPage<JobPosting> jobpage = jobPostingService.page(Page,queryWrapper);
        List<JobPosting> list = jobpage.getRecords();
        long total = jobpage.getTotal();
        return ResultData.success(new PageDto<>(total, list));
    }

    @GetMapping("/getjobinfo/{jid}")
    public ResultData getjobinfo(@PathVariable("jid")int jid){
        JobPosting jobPosting = jobPostingService.getById(jid);
        return ResultData.success(jobPosting);
    }

}
