<template>
  <a-card title="对话流程画布">
    <a-space style="margin-bottom:16px">
      <a-input v-model:value="flowName" placeholder="流程名称" style="width:200px" />
      <a-button type="primary" @click="addNode('start')">+ 开始节点</a-button>
      <a-button @click="addNode('ask')">+ 提问节点</a-button>
      <a-button @click="addNode('branch')">+ 分支节点</a-button>
      <a-button @click="addNode('end')">+ 结束节点</a-button>
      <a-button type="success" @click="saveFlow">保存流程</a-button>
    </a-space>
    <div ref="canvas" style="height:500px;border:1px solid #eee;background:#fafafa"></div>
  </a-card>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { Graph } from '@antv/x6'
import axios from 'axios'
import { message } from 'ant-design-vue'

const canvas = ref(null)
const flowName = ref('')
let graph = null
let nodeId = 0

onMounted(() => {
  graph = new Graph({
    container: canvas.value,
    background: { color: '#fafafa' },
    grid: true
  })
})

function addNode(type) {
  const colors = { start: '#52c41a', ask: '#1890ff', branch: '#faad14', end: '#f5222d' }
  graph.addNode({
    id: 'node_' + (++nodeId),
    shape: 'rect',
    x: 50 + (nodeId-1) * 150,
    y: 100,
    width: 120,
    height: 50,
    attrs: {
      body: { fill: colors[type], rx: 8, ry: 8 },
      label: { text: type.toUpperCase() + ' ' + nodeId, fill: '#fff' }
    }
  })
}

async function saveFlow() {
  const cells = graph.toJSON().cells
  await axios.post('/api/flows', {
    name: flowName.value,
    definitionJson: JSON.stringify(cells),
    version: 1,
    status: 1
  })
  message.success('流程已保存')
}
</script>
