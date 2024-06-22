package top.aprdec.recruitweb.mapper;

import org.apache.ibatis.annotations.Select;
import top.aprdec.recruitweb.pojo.Company;
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
public interface CompanyMapper extends BaseMapper<Company> {

    @Select("SELECT * FROM company ORDER BY RAND() LIMIT #{limit}")
    public List<Company> getRandomCompanies(int limit);
}
