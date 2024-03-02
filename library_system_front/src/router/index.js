import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/booklist',
    alias: '/',
    name: 'booklist',
    component: () => import('../views/BookListView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/signup',
    name: 'signup',
    component: () => import('../views/SignUpView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes
})

export default router
