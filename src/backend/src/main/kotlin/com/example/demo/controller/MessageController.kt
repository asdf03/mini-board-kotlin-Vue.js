package com.demo.controller

import com.demo.model.Message
import com.demo.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(private val messageService: MessageService) {

  @GetMapping
  fun listMessages(): ResponseEntity<List<Message>> {
    val messages = messageService.findAllMessages()
    return ResponseEntity.ok(messages)
  }

  @GetMapping("/{id}")
  fun getMessage(@PathVariable id: Long): ResponseEntity<Message> {
    val message = messageService.findMessageById(id)
    return if (message != null) ResponseEntity.ok(message) else ResponseEntity.notFound().build()
  }

  @PostMapping
  fun postMessage(@RequestBody message: Message): ResponseEntity<Message> {
    val saveMessage = messageService.saveMessage(message)
    return ResponseEntity.ok(saveMessage)
  }

  @DeleteMapping("/{id}")
  fun deleteMessage(@PathVariable id: Long): ResponseEntity<Void> {
    messageService.deleteMessage(id)
    return ResponseEntity.noContent().build()
  }
}
