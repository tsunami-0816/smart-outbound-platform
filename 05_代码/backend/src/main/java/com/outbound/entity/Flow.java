package com.outbound.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flows")
public class Flow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tenantId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String definitionJson;
    private Integer version;
    private Integer status; // 0草稿 1已发布
}
