package com.outbound.controller;

import com.outbound.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @GetMapping("/stats")
    public Result<Map<String, Object>> stats() {
        // TODO: 查询ClickHouse聚合
        return Result.ok(Map.of(
                "totalCalls", 1280,
                "connectRate", 0.62,
                "avgDuration", 85.3,
                "intentHigh", 156,
                "intentMid", 342,
                "intentLow", 520,
                "intentNone", 262
        ));
    }
}
