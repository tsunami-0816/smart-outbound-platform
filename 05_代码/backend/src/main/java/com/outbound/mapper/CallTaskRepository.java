package com.outbound.mapper;

import com.outbound.entity.CallTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallTaskRepository extends JpaRepository<CallTask, Long> {
    List<CallTask> findByTenantId(Long tenantId);
}
