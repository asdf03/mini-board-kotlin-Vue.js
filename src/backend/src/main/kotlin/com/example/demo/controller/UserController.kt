package com.demo.controller

import com.demo.model.User
import com.demo.service.UserService
import com.demo.controller.dto.LoginRequest
import com.demo.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/users")
class UserController(
  private val userService: UserService,
  private val jwtUtil: JwtUtil
) {

  @PostMapping
  fun createUser(@RequestBody user: User): ResponseEntity<User> {
    val createdUser = userService.createUser(user)
    return ResponseEntity.ok(createdUser)
  }

  @GetMapping
  fun getAllUsers(): ResponseEntity<List<User>> {
    val users = userService.findAllUsers()
    return ResponseEntity.ok(users)
  }

  @GetMapping("/{id}")
  fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
    val user = userService.findUserById(id)
    return ResponseEntity.ok(user)
  }

  @PutMapping("/{id}")
  fun updateUser(@PathVariable id: Long, @RequestBody updatedUserDetails: User): ResponseEntity<User> {
    val existingUser = userService.findUserById(id)
    return if (existingUser != null) {
      val updatedUser = userService.updateUser(id, updatedUserDetails)
      ResponseEntity.ok(updatedUser)
    } else {
      ResponseEntity.notFound().build()
    }
  }

  @DeleteMapping("/{id}")
  fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
    userService.deleteUser(id)
    return ResponseEntity.ok().build()
  }

  @PostMapping("/login")
  fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<String> {
    val user = userService.authenticate(loginRequest.email, loginRequest.password)
    return if (user != null) {
      val token = jwtUtil.generateToken(user.username)
      ResponseEntity.ok(token)
    } else {
      ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }
  }
}