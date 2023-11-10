package com.demo.model

import javax.presistence.*

@Entity
@Table(name = "users")
data class User(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,

  @Column(nullable = false, unique = true)
  val username: String,

  @Column(nullable = false, unique = true)
  val email: String,

  @Column(nullable = false)
  val password: String,
)