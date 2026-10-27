package com.outbound.mapper;

import com.outbound.entity.Flow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowRepository extends JpaRepository<Flow, Long> {
    List<Flow> findByTenantId(Long tenantId);
}
