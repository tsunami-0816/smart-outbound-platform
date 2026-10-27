package com.outbound.config;

import com.outbound.common.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String path = req.getRequestURI();
        if (path.startsWith("/api/auth/") || path.startsWith("/api/calls/stream")) {
            return true;
        }
        String token = req.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            resp.setStatus(401);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write("{\"code\":401,\"message\":\"未登录\"}");
            return false;
        }
        try {
            jwtUtil.parse(token.substring(7));
            return true;
        } catch (Exception e) {
            resp.setStatus(401);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write("{\"code\":401,\"message\":\"token无效\"}");
            return false;
        }
    }
}
