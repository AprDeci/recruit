package top.aprdec.recruitweb.mapper;

import org.apache.ibatis.annotations.Select;
import top.aprdec.recruitweb.pojo.Company;
import top.aprdec.recruitweb.pojo.Employer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.aprdec.recruitweb.pojo.JobPosting;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
public interface EmployerMapper extends BaseMapper<Employer> {

    @Select("""
            SELECT c.*
            FROM employer e
            JOIN company c ON e.company_id = c.id
            WHERE e.user_id = #{id};""")
    Company getCompanyByuid(Integer id);

    @Select("")
    List<JobPosting> getJobPostListByuid(Integer id);
}
