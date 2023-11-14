<template>
  <div>
    <h2>ログイン</h2>
    <form @submit.prevent="login">
      <input type="email" v-model="user.email" placeholder="メールアドレス">
      <input type="password" v-model="user.password" placeholder="パスワード">
      <button type="submit">ログイン</button>
    </form>

    <h2>ユーザー登録</h2>
    <form @submit.prevent="register">
      <input type="text" v-model="newUser.username" placeholder="ユーザー名">
      <input type="email" v-model="newUser.email" placeholder="メールアドレス">
      <input type="password" v-model="newUser.password" placeholder="パスワード">
      <button type="submit">登録</button>
    </form>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
import axios from 'axios'

export default {
  data() {
    return {
      user: {
        email: '',
        password: ''
      },
      newUser: {
        username: '',
        email: '',
        password: ''
      }
    };
  },
  methods: {
    ...mapActions(['login']),
    async performLogin() {
      try {
        await this.login({ email: this.user.email, password: this.user.password });
        this.$router.push('/');
      } catch (error) {
        alert('ログインに失敗しました。');
      }
    },
    async register() {
      try {
        const response = await axios.post('http://localhost:8080/users', this.newUser);
        console.log('User registered:', response.data);
        alert('ユーザー登録が完了しました。');
      } catch (error) {
        console.error('Registration failed:', error);
        alert('ユーザー登録に失敗しました。');
      }
    }
  }
}
</script>