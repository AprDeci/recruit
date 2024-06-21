package top.aprdec.recruitweb.mapper;

import org.apache.ibatis.annotations.Select;
import top.aprdec.recruitweb.DTO.EmployeeDTO;
import top.aprdec.recruitweb.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
public interface UserMapper extends BaseMapper<User> {


    @Select("SELECT e.*, u.username " +
            "FROM employee e " +
            "JOIN user u ON e.user_id = u.id " +
            "WHERE e.user_id = #{id};")
    EmployeeDTO getEmployeeDTOById(Integer id);
}
