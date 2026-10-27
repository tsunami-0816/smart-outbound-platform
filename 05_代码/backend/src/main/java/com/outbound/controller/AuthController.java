package com.outbound.controller;

import com.outbound.common.JwtUtil;
import com.outbound.common.Result;
import com.outbound.entity.User;
import com.outbound.mapper.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        User user = userRepo.findByUsername(body.get("username"))
                .orElseThrow(() -> new RuntimeException("用户不存在"));
        if (!user.getPassword().equals(body.get("password"))) {
            return Result.error(401, "密码错误");
        }
        String token = jwtUtil.generate(user.getId(), user.getUsername(), user.getRole());
        return Result.ok(Map.of("token", token, "role", user.getRole(), "username", user.getUsername()));
    }
}
