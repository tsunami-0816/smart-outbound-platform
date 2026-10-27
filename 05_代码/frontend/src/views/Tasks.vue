<template>
  <a-card title="外呼任务">
    <a-button type="primary" @click="showCreate = true">创建任务</a-button>
    <a-table :columns="columns" :data-source="tasks" row-key="id" style="margin-top:16px">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key === 'action'">
          <a-button size="small" type="primary" @click="startTask(record.id)">启动</a-button>
        </template>
      </template>
    </a-table>
    <a-modal v-model:open="showCreate" title="创建任务" @ok="createTask">
      <a-input v-model:value="newTask.name" placeholder="任务名" style="margin-bottom:8px" />
      <a-input-number v-model:value="newTask.totalCount" placeholder="号码数" style="width:100%" />
    </a-modal>
  </a-card>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'
import axios from 'axios'
import { message } from 'ant-design-vue'
const tasks = ref([])
const showCreate = ref(false)
const newTask = reactive({ name: '', totalCount: 100 })
const columns = [
  { title: 'ID', dataIndex: 'id' },
  { title: '名称', dataIndex: 'name' },
  { title: '总数', dataIndex: 'totalCount' },
  { title: '成功', dataIndex: 'successCount' },
  { title: '状态', dataIndex: 'status' },
  { title: '操作', key: 'action' }
]
async function load() {
  const res = await axios.get('/api/tasks')
  tasks.value = res.data.data
}
async function createTask() {
  await axios.post('/api/tasks', newTask)
  showCreate.value = false
  load()
}
async function startTask(id) {
  await axios.post(`/api/tasks/${id}/start`)
  message.success('任务已启动')
  load()
}
onMounted(load)
</script>
