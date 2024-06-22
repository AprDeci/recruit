package top.aprdec.recruitweb.service;

import top.aprdec.recruitweb.DTO.CompanyWithJobsDTO;
import top.aprdec.recruitweb.pojo.Company;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
public interface CompanyService extends IService<Company> {
    List<CompanyWithJobsDTO> getCompanyWithJobs();
}
