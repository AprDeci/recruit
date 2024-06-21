package top.aprdec.recruitweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.aprdec.recruitweb.mapper.EmployerMapper;
import top.aprdec.recruitweb.pojo.Company;
import top.aprdec.recruitweb.pojo.ResultData;
import top.aprdec.recruitweb.service.CompanyService;
import top.aprdec.recruitweb.service.EmployerService;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

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

}
