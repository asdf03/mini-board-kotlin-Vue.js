package com.demo.repository

import com.demo.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {

  fun findAllByMessageId(messageId: Long): List<Comment>

  fun findAllByUserId(userId: Long): List<Comment>

} 