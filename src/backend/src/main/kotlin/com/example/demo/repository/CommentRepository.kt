package com.demo.repository

import com.demo.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Commnet: Long> {

  fun findByMessageId(messageId: Long): List<Commnet>

  fun findByUserId(userId: Long): List<Commnet>
  
} 