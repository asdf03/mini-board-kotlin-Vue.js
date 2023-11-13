package com.demo.repository

import com.demo.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
  fun findAllByUserId(userId: Long): List<Message>
}