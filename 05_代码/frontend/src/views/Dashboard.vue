<template>
  <a-row :gutter="16">
    <a-col :span="6"><a-statistic title="总通话数" :value="stats.totalCalls" /></a-col>
    <a-col :span="6"><a-statistic title="接通率" :value="stats.connectRate * 100" suffix="%" /></a-col>
    <a-col :span="6"><a-statistic title="平均时长(秒)" :value="stats.avgDuration" /></a-col>
    <a-col :span="6"><a-statistic title="高意向客户" :value="stats.intentHigh" /></a-col>
  </a-row>
  <a-divider />
  <a-row :gutter="16">
    <a-col :span="12">
      <a-card title="意向分布">
        <a-statistic title="高意向" :value="stats.intentHigh" />
        <a-statistic title="中意向" :value="stats.intentMid" />
        <a-statistic title="低意向" :value="stats.intentLow" />
        <a-statistic title="无意向" :value="stats.intentNone" />
      </a-card>
    </a-col>
  </a-row>
</template>
<script setup>
import { reactive, onMounted } from 'vue'
import axios from 'axios'
const stats = reactive({ totalCalls: 0, connectRate: 0, avgDuration: 0, intentHigh: 0, intentMid: 0, intentLow: 0, intentNone: 0 })
onMounted(async () => {
  const res = await axios.get('/api/dashboard/stats')
  Object.assign(stats, res.data.data)
})
</script>
