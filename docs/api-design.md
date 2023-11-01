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

(以下略)
