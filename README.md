# smart-outbound-platform

基于 FreeSWITCH + LLM 的 AI 智能外呼语音对话平台

## 技术栈
- 后端：Java 17 + Spring Boot 3 + JPA + Redis + RabbitMQ
- 前端：Vue3 + TypeScript + Ant Design Vue + AntV X6
- 通信：FreeSWITCH (Docker) + ESL 事件驱动
- 存储：MySQL 8 + ClickHouse
- 部署：Docker Compose

## 功能
- 多租户管理
- 可视化对话流程画布（AntV X6 拖拽编排）
- 外呼任务调度与批量拨号
- 实时对话循环（ASR→LLM→TTS）
- SSE 实时通话监控
- 通话后摘要与意向标签
- 运营看板（接通率/时长/意向分布）

## 快速启动
```bash
cd 05_代码
docker compose up -d
cd backend && mvn spring-boot:run
cd ../frontend && npm install && npm run dev
```

访问 http://localhost:5174
