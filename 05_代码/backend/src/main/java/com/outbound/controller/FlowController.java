package com.outbound.controller;

import com.outbound.common.Result;
import com.outbound.entity.Flow;
import com.outbound.mapper.FlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flows")
@RequiredArgsConstructor
public class FlowController {

    private final FlowRepository flowRepo;

    @GetMapping
    public Result<List<Flow>> list() {
        return Result.ok(flowRepo.findAll());
    }

    @PostMapping
    public Result<Flow> save(@RequestBody Flow flow) {
        return Result.ok(flowRepo.save(flow));
    }

    @GetMapping("/{id}")
    public Result<Flow> get(@PathVariable Long id) {
        return Result.ok(flowRepo.findById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        flowRepo.deleteById(id);
        return Result.ok(null);
    }
}
