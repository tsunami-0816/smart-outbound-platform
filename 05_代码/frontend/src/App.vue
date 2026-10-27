<template>
  <a-layout style="min-height:100vh">
    <a-layout-sider v-if="$route.path !== '/login'">
      <div style="color:#fff;padding:16px;font-weight:bold">智能外呼平台</div>
      <a-menu theme="dark" mode="inline" :selected-keys="[$route.path]">
        <a-menu-item key="/dashboard" @click="$router.push('/dashboard')">看板</a-menu-item>
        <a-menu-item key="/flows" @click="$router.push('/flows')">对话流程</a-menu-item>
        <a-menu-item key="/tasks" @click="$router.push('/tasks')">外呼任务</a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout-content style="padding:24px">
      <router-view />
    </a-layout-content>
  </a-layout>
</template>
