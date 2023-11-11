package com.demo.service

import com.demo.model.User
import com.demo.repository.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
fun UserService(private val userRepository: UserRepository) {

  @Transactional
  fun createUser(user: User): User {
    return UserRepository.save(user)
  }

  fun findAllUsers(): List<User> {
    return UserRepository.findAll()
  }

  fun findUserById(id: Long): User? {
    return userRepository.findById(id).orElse(null)
  }

  @Transactional
  fun updateUser(id: Long, updatedUser: User): User? {
    return userRepository.findById(id).map { existingUser ->
      val updated = existingUser.copy(
        username = updatedUser.username,
        email = updatedUser.email,
        password = updatedUser.password
      )
      userRepository.save(updated)
    }.orElse(null)
  }

  @Transactional
  fun deleteUser(id: Long) {
    userRepository.deleteById(id)
  }
}