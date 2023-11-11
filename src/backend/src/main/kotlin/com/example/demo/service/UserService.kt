package com.demo.service

import com.demo.model.User
import com.demo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

  @Transactional
  fun createUser(user: User): User {
    return userRepository.save(user)
  }

  fun findAllUsers(): List<User> {
    return userRepository.findAll()
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