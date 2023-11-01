# テーブル定義書

## ユーザーテーブル

| 列名 | 型 | 制約 |  
| - | - | - |
| id | INTEGER | PRIMARY KEY, AUTO INCREMENT |
| name | VARCHAR(255) | NOT NULL |
| email | VARCHAR(255) | NOT NULL, UNIQUE |  
| password | VARCHAR(255) | NOT NULL |

ユーザーのアカウント情報を格納するテーブルです。

- id: ユーザーを一意に識別するID
- name: ユーザー名
- email: ログインに使用するメールアドレス
- password: 認証に使用するパスワード

## 投稿テーブル

| 列名 | 型 | 制約 |
| - | - | - | 
| id | INTEGER | PRIMARY KEY, AUTO INCREMENT |
| user_id | INTEGER | FOREIGN KEY |
| title | VARCHAR(255) | NOT NULL |
| content | TEXT | NOT NULL |

ユーザーが投稿する記事を格納するテーブルです。

- id: 投稿を一意に識別するID  
- user_id: 投稿者を識別するユーザーID
- title: 記事のタイトル
- content: 記事の本文
