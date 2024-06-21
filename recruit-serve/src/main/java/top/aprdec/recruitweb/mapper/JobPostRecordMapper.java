package top.aprdec.recruitweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import top.aprdec.recruitweb.DTO.JobRecordDTO;
import top.aprdec.recruitweb.pojo.JobPostRecord;
import top.aprdec.recruitweb.pojo.JobPosting;

import java.util.List;

public interface JobPostRecordMapper extends BaseMapper<JobPostRecord> {

    @Results({
            @Result(property = "employee_fullname", column = "employee_fullname"),
            @Result(property = "employer_name", column = "employer_name"),
            @Result(property = "company_name", column = "company_name"),
            @Result(property = "job_title", column = "job_title"),
            @Result(property = "job_description", column = "job_description"),
            @Result(property = "maxsalary", column = "max_salary"),
            @Result(property = "minsalary", column = "min_salary"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT e.fullname AS employee_fullname, em.name AS employer_name, c.name AS company_name, jp.title AS job_title, jp.description AS job_description, jp.max_salary AS max_salary, jp.min_salary AS min_salary,jpr.status\n" +
            "FROM jobpostrecords jpr\n" +
            "JOIN employee e ON jpr.employeeid = e.id\n" +
            "JOIN employer em ON jpr.employerid = em.id\n" +
            "JOIN company c ON jpr.companyid = c.id\n" +
            "JOIN job_posting jp ON jpr.jobid = jp.id\n" +
            "WHERE  userid= #{id}")
    List<JobRecordDTO> employeegetParseRecordList(Integer id);

    @Results({
            @Result(property = "employee_fullname", column = "employee_fullname"),
            @Result(property = "employer_name", column = "employer_name"),
            @Result(property = "company_name", column = "company_name"),
            @Result(property = "job_title", column = "job_title"),
            @Result(property = "job_description", column = "job_description"),
            @Result(property = "maxsalary", column = "max_salary"),
            @Result(property = "minsalary", column = "min_salary"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT e.fullname AS employee_fullname, em.name AS employer_name, c.name AS company_name, jp.title AS job_title, jp.description AS job_description, jp.max_salary AS max_salary, jp.min_salary AS min_salary,jpr.status\n" +
            "FROM jobpostrecords jpr\n" +
            "JOIN employee e ON jpr.employeeid = e.id\n" +
            "JOIN employer em ON jpr.employerid = em.id\n" +
            "JOIN company c ON jpr.companyid = c.id\n" +
            "JOIN job_posting jp ON jpr.jobid = jp.id\n" +
            "WHERE employeruid = #{id}")
    List<JobRecordDTO> employergetParseRecordList(Integer id);
}
