package com.demo.model

import java.time.LocalDateTime
import javax.presistence.*

@Entity
@Table(name = "messages")
data class Message(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,

  @Column(nullable = false, columnDefinition = "TEXT", length = 500)
  val content: String,

  @Column(nullable = false)
  val timestamp: LocalDateTime = LocalDateTime.now(),

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  val user: User

  @OneToMany(mappedBy = "message", cascade = [CascadeType.All], fetch = FetchType.LAZY)
  val comments: List<Comment> = mutableListOf()
)