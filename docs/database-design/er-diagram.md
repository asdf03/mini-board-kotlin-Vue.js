```
erDiagram
    USER ||--o{ MESSAGE : posts
    USER {
        string username
        string email
        string password
    }
    MESSAGE }|--|| COMMENT : has
    MESSAGE {
        int id
        string content
        datetime timestamp
        string author
    }
    COMMENT ||--|{ USER : writes
    COMMENT {
        int id 
        string content
        datetime timestamp
        string author
    }
```
