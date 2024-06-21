package top.aprdec.recruitweb.service.impl;

import top.aprdec.recruitweb.pojo.Employee;
import top.aprdec.recruitweb.mapper.EmployeeMapper;
import top.aprdec.recruitweb.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
