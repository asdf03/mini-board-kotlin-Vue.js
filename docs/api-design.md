# API仕様

## ユーザー管理API

### ユーザー登録 [POST /api/v1/users]

+ リクエスト

  + Body

    ```json
    {
      "username": "testuser",
      "email": "test@example.com",
      "password": "password" 
    }
    ```

+ レスポンス

  + Body

    ```json
    {
      "id": 1,
      "username": "testuser",
      "email": "test@example.com"
    }
    ```

### ログイン [POST /api/v1/login]

+ リクエスト

  + Body

    ```json
    {
      "email": "test@example.com",
      "password": "password"
    }
    ```

+ レスポンス

  + Body

    ```json  
    {
      "token": "xxxxxxx" 
    }
    ```

##メッセージ管理API

### メッセージ投稿 [POST /api/v1/messages]

+ リクエスト

  ヘッダー: Authorization: Bearer {token}

  + Body

    ```json
    {
      "content": "Hello, World!"
    }
    ```
    
+ レスポンス

  + Body

    ```json
    {
      "id": 1,
      "content": "Hello, World!",
      "createdAt": "2023-11-02T12:34:56.789Z",
      "author": {
        "id": 1,
        "username": "testuser"
      }
    }
    ```
    
### メッセージ一覧取得 [GET /api/v1/messages]

+ リクエスト: なし（クエリパラメータでページネーションやフィルタリングが可能）

+ レスポンス

  + Body

    ```json
    {
      "messages": [
        {
          "id": 1,
          "content": "Hello, World!",
          "createdAt": "2023-11-02T12:34:56.789Z",
          "author": {
            "id": 1,
            "username": "testuser"
          }
        },
        // 他のメッセージ
      ],
      "total": 100,
      "page": 1,
      "pageSize": 10
    }
    ```

### メッセージ削除 [DELETE /api/v1/messages/{messageId}]

+ リクエスト

  ヘッダー: Authorization: Bearer {token}

  パスパラメータ: messageId - 削除するメッセージのID

  レスポンス: ステータスコード204（No Content）でレスポンスを返す

### WebSocket

  メッセージのリアルタイム更新

  エンドポイント: /ws/messages

  イベント: "message"

  データ:

    ```
    json
    {
      "id": 1,
      "content": "Hello, World!",
      "createdAt": "2023-11-02T12:34:56.789Z",
      "author": {
        "id": 1,
        "username": "testuser"
      }
    }
    ```
