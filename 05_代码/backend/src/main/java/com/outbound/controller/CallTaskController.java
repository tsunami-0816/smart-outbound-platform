package com.outbound.controller;

import com.outbound.common.Result;
import com.outbound.entity.CallTask;
import com.outbound.mapper.CallTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class CallTaskController {

    private final CallTaskRepository taskRepo;

    @GetMapping
    public Result<List<CallTask>> list() {
        return Result.ok(taskRepo.findAll());
    }

    @PostMapping
    public Result<CallTask> create(@RequestBody CallTask task) {
        task.setStatus(0);
        task.setSuccessCount(0);
        return Result.ok(taskRepo.save(task));
    }

    @PostMapping("/{id}/start")
    public Result<String> start(@PathVariable Long id) {
        CallTask task = taskRepo.findById(id).orElseThrow();
        task.setStatus(1);
        taskRepo.save(task);
        // TODO: 接入RabbitMQ分发号码
        return Result.ok("任务已启动");
    }
}
