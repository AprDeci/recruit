package top.aprdec.recruitweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.aprdec.recruitweb.pojo.Company;
import top.aprdec.recruitweb.pojo.JobPosting;

import java.util.List;
@Data
@AllArgsConstructor
public class CompanyWithJobsDTO {
    private Company company;
    private List<JobPosting> jobs;

}
