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
    return commentService.updateComment(id, comment)?.let {
      ResponseEntity.ok(it)
    } ?: ResponseEntity.notFound().build()
  }

  @DeleteMapping("/{id}")
  fun deleteComment(@PathVariable id: Long): ResponseEntity<Void> {
    return if (commentService.existsById(id)) {
      commentService.deleteComment(id)
      ResponseEntity.noContent().build()
    } else {
      ResponseEntity.notFound().build()
    }
  }
}