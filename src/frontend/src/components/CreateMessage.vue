<template>
  <div>
    <h2>メッセージ作成</h2>
    <form @submit.prevent="createMessage">
      <textarea v-model="message.content" placeholder="メッセージ内容"></textarea>
      <button type="submit">投稿</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: {
        content: ''
      }
    };
  },
  methods: {
    createMessage() {
      // ここでメッセージ作成のロジックを実装します
      console.log(this.message);
    }
  }
}
</script>