package top.aprdec.recruitweb.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.aprdec.recruitweb.service.UserService;
import top.aprdec.recruitweb.util.JWTutil;
import top.aprdec.recruitweb.util.ThreadLocalUtil;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
//            claim存有id和username
            Map<String, Object> claims = JWTutil.parse(token);
//            存储用户数据-ThreadLocal
            ThreadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
