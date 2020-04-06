package com.square.interceptor;

import com.square.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/24
 * Description:
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 都放行，具体能不能操作，在具体的操作中判断。
        // 拦截器只是负责把有请求头中包含token的令牌进行解析。
        String header = request.getHeader("Authorization");
        if (header != null && !"".equals(header)) {
            // 包含有头信息，进行解析
            if (header.startsWith("Bearer ")) {
                // 获得令牌
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")) {
                        request.setAttribute("claims_admin", token);
                    }
                    if (roles != null && roles.equals("user")) {
                        request.setAttribute("calims_user", token);
                    }

                } catch (Exception e) {
                    throw new RuntimeException("令牌不正确!");
                }
            }
        }

        return true;
    }
}
