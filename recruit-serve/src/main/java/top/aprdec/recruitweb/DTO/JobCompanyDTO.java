package top.aprdec.recruitweb.DTO;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
@Data
public class JobCompanyDTO {

    private String company_name;

    private String company_description;

    private String company_location;

    private String company_industry;

    private String job_id;

    private String job_title;

    private String job_description;

    private String job_requirements;

    private String job_location;

    private LocalDate job_postingDate;

    private Integer maxSalary;

    private Integer minSalary;

    private String job_type;

    private String salary;

    private String[] tags;

    public void initst(){
        this.tags=this.job_requirements.split(",");
        this.salary= (int)Math.floor((double) this.maxSalary/1000) + "K-" +(int) Math.floor((double) this.minSalary/1000)+"K";
    }
}
