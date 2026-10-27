<template>
  <div style="max-width:400px;margin:100px auto">
    <h2>智能外呼平台登录</h2>
    <a-form :model="form" @finish="doLogin">
      <a-form-item label="用户名" name="username">
        <a-input v-model:value="form.username" />
      </a-form-item>
      <a-form-item label="密码" name="password">
        <a-input-password v-model:value="form.password" />
      </a-form-item>
      <a-button type="primary" html-type="submit" block>登录</a-button>
    </a-form>
  </div>
</template>
<script setup>
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
import { message } from 'ant-design-vue'

const form = reactive({ username: 'admin', password: 'admin123' })
const router = useRouter()

async function doLogin() {
  const res = await axios.post('/api/auth/login', form)
  localStorage.setItem('token', res.data.data.token)
  message.success('登录成功')
  router.push('/dashboard')
}
</script>
