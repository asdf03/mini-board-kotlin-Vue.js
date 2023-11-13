package com.demo.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long?,

  @Column(nullable = false, unique = true)
  val username: String,

  @Column(nullable = false, unique = true)
  val email: String,

  @Column(nullable = false)
  val password: String,

  @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  val messages: List<Message> = mutableListOf(),

  @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  val comments: List<Comment> = mutableListOf(),
)