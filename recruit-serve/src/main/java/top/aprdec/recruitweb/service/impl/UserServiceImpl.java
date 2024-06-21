package top.aprdec.recruitweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.aprdec.recruitweb.DTO.EmployeeDTO;
import top.aprdec.recruitweb.pojo.User;
import top.aprdec.recruitweb.mapper.UserMapper;
import top.aprdec.recruitweb.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
