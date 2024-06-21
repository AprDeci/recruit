package top.aprdec.recruitweb.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import top.aprdec.recruitweb.DTO.EmployeeDTO;
import top.aprdec.recruitweb.mapper.UserMapper;
import top.aprdec.recruitweb.pojo.*;
import top.aprdec.recruitweb.service.EmployeeService;
import top.aprdec.recruitweb.service.EmployerService;
import top.aprdec.recruitweb.service.UserService;
import top.aprdec.recruitweb.util.JWTutil;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author aprdec
 * @since 2024-06-11 11:03:10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResultData login(String username, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            return ResultData.error("用户不存在");
        }else {
            if (user.getPassword().equals(password)) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id",user.getId());
                claims.put("username", user.getUsername());
                claims.put("role",user.getRole());
                String token = JWTutil.createToken(claims);
                String role = user.getRole();
                return ResultData.success(new TokenandRole(token,role));
            }else {
                return ResultData.error("密码错误");
            }
        }
    }


    @PostMapping("/register")
    public ResultData register(String username, String password, String role) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User u = userService.getOne(queryWrapper);
        if (u != null) {
            return ResultData.error("用户名已存在");
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.save(user);
            user = userService.getOne(queryWrapper);
            //根据user的role给其他表添加数据
            if ("employee".equals(role)){
                Employee employee= new Employee();
                employee.setUserId(user.getId());
                employeeService.save(employee);
            }else if ("employer".equals(role)){
                Employer employer= new Employer();
                employer.setUserId(user.getId());
                employerService.save(employer);
            }
            return ResultData.success("注册成功");
        }
    }

    @GetMapping("/info")
    public ResultData info(@RequestHeader(name = "Authorization") String token){
        Map<String,Object> claims = ThreadLocalUtil.get();
        User user = userService.getById((Integer) claims.get("id"));
        if ("employee".equals(user.getRole())) {
            QueryWrapper<Employee> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("user_id", user.getId());
            Employee employee = employeeService.getOne(queryWrapper1);
            return ResultData.success(employee);
        }
         if ("employer".equals(user.getRole())){
             QueryWrapper<Employer> queryWrapper2 = new QueryWrapper<>();
             queryWrapper2.eq("user_id", user.getId());
            Employer employer = employerService.getOne(queryWrapper2);
            return ResultData.success(employer);
        }
         return ResultData.success("1");
    }
    @GetMapping("/info2")
    public ResultData info2(@RequestHeader(name = "Authorization") String token){
        Map<String,Object> claims = ThreadLocalUtil.get();
        User user = userService.getById((Integer) claims.get("id"));
        if ("employee".equals(user.getRole())) {
           EmployeeDTO employeeDTO= userMapper.getEmployeeDTOById((Integer) claims.get("id"));
            return ResultData.success(employeeDTO);
        }
        if ("employer".equals(user.getRole())){
            QueryWrapper<Employer> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("user_id", user.getId());
            Employer employer = employerService.getOne(queryWrapper2);
            return ResultData.success(employer);
        }
        return ResultData.success("1");
    }


    @PutMapping("/update/employee")
    public ResultData update(@RequestBody @Validated Employee employee){
        boolean is = employeeService.updateById(employee);
        if (is) return ResultData.success("更新成功");
        else return ResultData.error("更新失败");
    }
    @PutMapping("/update/employer")
    public ResultData update(@RequestBody Employer employer){
        boolean is = employerService.updateById(employer);
        if (is) return ResultData.success("更新成功");
        else return ResultData.error("更新失败");
    }

    @PostMapping("/updatdPwd")
    public ResultData updatePwd(@RequestBody Map<String, String> params){
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String rePwd = params.get("rePwd");

        if (newPwd.equals(rePwd)) {
            Map<String, Object> claims = ThreadLocalUtil.get();
            User user = userService.getById((Integer) claims.get("id"));
            if (user.getPassword().equals(oldPwd)) {
                user.setPassword(newPwd);
                userService.updateById(user);
                return ResultData.success("修改成功");
            }else {
                return ResultData.error("旧密码错误");
            }
        }else {
            return ResultData.error("两次密码不一致");
        }
    }



}
