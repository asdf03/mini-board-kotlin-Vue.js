package com.demo.service

import com.demo.model.Message
import com.demo.repository.MessageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MessageService(private val messageRepository: MessageRepository) {

  @Transactional
  fun saveMessage(message: Message): Message {
    return messageRepository.save(message)
  }

  fun findAllMessages(): List<Message> {
    return messageRepository.findAll()
  }

  fun findMessageById(id: Long): Message? {
    return messageRepository.findById(id).orElse(null)
  }

  fun findAllMessagesByUserId(userId: Long): List<Message> {
    return messageRepository.findAllByUserId(userId)
  }

  @Transactional
  fun deleteMessage(id: Long) {
    messageRepository.deleteById(id)
  }
}
