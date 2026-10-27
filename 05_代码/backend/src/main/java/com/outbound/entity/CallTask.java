package com.outbound.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "call_tasks")
public class CallTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tenantId;
    private Long flowId;
    private String name;
    private Integer totalCount;
    private Integer successCount;
    private Integer status; // 0待执行 1执行中 2已完成
}
