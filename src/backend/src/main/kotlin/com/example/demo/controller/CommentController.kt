package com.demo.controller

import com.demo.model.Comment
import com.demo.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(private val commentService: CommentService) {

  @GetMapping("/message/{messageId}")
  fun getAllCommentsByMessageId(@PathVariable messageId: Long): ResponseEntity<List<Comment>> {
    val comments = commentService.findAllCommentByMessageId(messageId)
    return ResponseEntity.ok(comments)
  }

  @PostMapping
  fun createComment(@RequestBody comment: Comment): ResponseEntity<Comment> {
    val newComment = commentService.createComment(comment)
    return ResponseEntity.ok(newComment)
  }

  @PutMapping("/{id}")
  fun updateComment(@PathVariable id: Long, @RequestBody comment: Comment): ResponseEntity<Comment> {
    val updatedCommentOptional = commentService.updateComment(id, comment)
    return if (updatedCommentOptional.isPresent) {
      ResponseEntity.ok(updatedCommentOptional.get())
    } else {
      ResponseEntity.notFound().build()
    }
  }

  @DeleteMapping("/{id}")
  fun deleteComment(@PathVariable id: Long): ResponseEntity<Void> {
    commentService.deleteComment(id)
    return ResponseEntity.noContent().build()
  }
}