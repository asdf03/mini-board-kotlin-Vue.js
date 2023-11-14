import { createRouter, createWebHistory } from 'vue-router'
import store from '../store'
import Login from '../views/UserLogin.vue'
import Home from '../views/UserHome.vue'
import Message from '../views/UserMessage.vue'

const routes = [
  {
    path: '/login',
    name: 'UserLogin',
    component: Login
  },
  {
    path: '/',
    name: 'UserHome',
    component: Home
  },
  {
    path: '/message/:id',
    name: 'UserMessage',
    component: Message
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  const isLoggedIn = store.state.isLoggedIn;
  if (to.name !== 'UserLogin' && !isLoggedIn) {
    next({ name: 'UserLogin' });
  } else if (to.name === 'UserLogin' && isLoggedIn) {
    next({ name: 'UserHome' });
  } else {
    next();
  }
});

export default router
