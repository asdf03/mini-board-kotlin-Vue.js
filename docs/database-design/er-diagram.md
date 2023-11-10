```
erDiagram
    USER ||--o{ MESSAGE : "posts"
    USER ||--o{ COMMENT : "writes"
    MESSAGE ||--o{ COMMENT : "has"

    USER {
        Long id
        string username
        string email
        string password
        list messages
        list comments
    }
    MESSAGE {
        Long id
        string content
        LocalDateTime timestamp
        USER user
        list comments
    }
    COMMENT {
        Long id
        string content
        LocalDateTime timestamp
        USER user
        MESSAGE message
    }
```
