package com.demo.service

import com.demo.model.Comment
import com.demo.repository.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@service
class CommentService(private val commentRepository: CommentRepository) {
  
  @Transactional
  saveComment(comment: Comment): Comment {
    return commentRepository.save(comment)
  }

  fun findAllComment(): List<Comment> {
    return commentRepository.findAll()
  }

  fun findCommentById(id: Long): Comment? {
    return commentRepository.findById(id).orElse(null)
  }

  fun findAllCommentByMessageId(messageId: Long): List<Commnet> {
    return commentRepository.findAllByMessageId(messageId)
  }

  fun findAllCommentByUserId(userId: Long): List<Commnet> {
    return commentRepository.findAllByUserId(userId)
  }
}