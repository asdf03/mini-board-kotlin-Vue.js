package com.demo.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.Claims
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtUtil {
  private val secret = "your-secret-key" // 環境変数から取得する方が良い

  fun generateToken(username: String): String {
    return Jwts.builder()
      .setSubject(username)
      .setIssuedAt(Date(System.currentTimeMillis()))
      .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10時間
      .signWith(SignatureAlgorithm.HS256, secret)
      .compact()
  }

  fun validateToken(token: String, username: String): Boolean {
    val extractUsername = extractUsername(token)
    return (extractUsername == username) && !isTokenExpired(token)
  }

  fun extractUsername(token: String): String {
    return extractClaim(token) { it.subject }
  }

  private fun isTokenExpired(token: String): Boolean {
    return extractClaim(token) { it.expiration }.before(Date())
  }

  private fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T {
    val claims = extractAllClaims(token)
    return claimsResolver(claims)
  }

  private fun extractAllClaims(token: String): Claims {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
  }
}