import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    isLoggedIn: false,
    token: ''
  },
  mutations: {
    setToken(state, token) {
      state.token = token
      state.isLoggedIn = !!token
    },
    logout(state) {
      state.token = ''
      state.isLoggedIn = false
    }
  },
  actions: {
    async login({ commit }, credentials) {
      try {
        const response = await axios.post('http://localhost:8080/users/login', credentials)
        const token = response.data
        commit('setToken', token)
        localStorage.setItem('token', token)
      } catch (error) {
        console.error('Login failed:', error)
      }
    },
    logout({ commit }) {
      commit('logout')
      localStorage.removeItem('token')
    }
  }
})
