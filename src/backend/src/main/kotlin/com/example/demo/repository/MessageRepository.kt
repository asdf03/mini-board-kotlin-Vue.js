package com.demo.repository

import com.demo.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {}