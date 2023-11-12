package com.demo.config

import org.springframework.context.annotation.Been
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.password.PasswordEncoder

@Configuration
class securityConfig {

  @Bean
  fun PasswordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }
}