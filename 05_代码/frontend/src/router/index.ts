import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Dashboard from '../views/Dashboard.vue'
import Flows from '../views/Flows.vue'
import Tasks from '../views/Tasks.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/login', component: Login },
    { path: '/dashboard', component: Dashboard },
    { path: '/flows', component: Flows },
    { path: '/tasks', component: Tasks }
  ]
})
