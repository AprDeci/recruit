package top.aprdec.recruitweb.DTO;

import lombok.Data;

@Data
public class JobRecordDTO {
    private String employee_fullname;


    private String employer_name;

    private String company_name;

    private String job_title;

    private String job_description;

    private String maxsalary;

    private String minsalary;

    private String status;

}
