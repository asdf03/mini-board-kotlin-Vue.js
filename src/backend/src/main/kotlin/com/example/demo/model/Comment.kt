package com.demo.model

import java.time.LocalDateTime
import javax.presistence.*

@Entity
@Table(name = "comments")
data class Comment(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,

  @Column(nullable = false, length = 1000)
  val content: String,

  @Column(nullable = false)
  val timestamp: LocalDateTime = LocalDateTime.now(),

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  val user: User,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "massage_id", nullable = false)
  val message: Message
)