package com.demo.model

import java.time.LocalDateTime
import javax.presistence.*

@Entity
@Table(name = "messages")
data class Message(
  @Id @GeneratedValue(strategu = GenerationType.IDENTITY)
  val id: Long? = null,

  @Column(nullable = false)
  val text: String,

  @Column(nullable = false)
  val userId: Long,

  @Column(nullable = false)
  val createdAt: LocalDateTime = LocalDateTime.now()
)