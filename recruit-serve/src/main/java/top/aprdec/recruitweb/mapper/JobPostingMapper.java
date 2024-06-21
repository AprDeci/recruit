package top.aprdec.recruitweb.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import top.aprdec.recruitweb.DTO.JobCompanyDTO;
import top.aprdec.recruitweb.pojo.JobPosting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
public interface JobPostingMapper extends BaseMapper<JobPosting> {


    @Select("""
            SELECT jp.*\s
            FROM employer e\s
            JOIN job_posting jp ON e.id = jp.employer_id\s
            WHERE e.user_id = #{id};""")
    List<JobPosting> getJobListByuid(Integer id);


    @Select("SELECT * FROM job_posting ORDER BY RAND() LIMIT #{limit}")
    List<JobPosting> getJobListByRandom(int limit);




    @Select("SELECT c.name AS company_name, c.description AS company_description, c.location AS company_location, c.industry AS company_industry, j.title AS job_title, j.description AS job_description, j.requirements AS job_requirements, j.location AS job_location, j.posting_date AS job_postingDate, j.max_salary AS maxSalary, j.min_salary AS minSalary, j.type AS job_type FROM job_posting j JOIN company c ON j.company_id = c.id WHERE j.id = #{id} ORDER BY RAND() LIMIT #{limit}")
    @Results({
            @Result(column = "company_name", property = "company_name"),
            @Result(column = "company_description", property = "company_description"),
            @Result(column = "company_location", property = "company_location"),
            @Result(column = "company_industry", property = "company_industry"),
            @Result(column = "job_title", property = "job_title"),
            @Result(column = "job_description", property = "job_description"),
            @Result(column = "job_requirements", property = "job_requirements"),
            @Result(column = "job_location", property = "job_location"),
            @Result(column = "job_postingDate", property = "job_postingDate"),
            @Result(column = "maxSalary", property = "maxSalary"),
            @Result(column = "minSalary", property = "minSalary"),
            @Result(column = "job_type", property = "job_type")
    })
    JobCompanyDTO getJobAndCompanyById(@Param("id") int jobPostingId,@Param("limit") int limit);

}
