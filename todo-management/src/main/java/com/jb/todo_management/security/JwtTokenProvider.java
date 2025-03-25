
// package com.jb.todo_management.security;

// import java.security.Key;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtTokenProvider {

//     @Value("${app.jwt-secret}")
//     private String jwtSecret;

//     @Value("${app.jwt-expiration-milliseconds}")
//     private long jwtExpirationDate;

//     // Generate JWT Token
//     public String generateToken(Authentication authentication) {
//         String username = authentication.getName();
//         Date currentDate = new Date();
//         Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

//         // Corrected method names for version 0.12.6
//         String token = Jwts.builder()
//             .setSubject(username)  // Corrected from subject()
//             .setIssuedAt(currentDate)  // Corrected from issuedAt()
//             .setExpiration(expireDate)  // Corrected from expiration()
//             .signWith(key(), SignatureAlgorithm.HS256)  // Corrected to use key() and algorithm
//             .compact();

//         return token;
//     }

//     // Generate key from secret
//     private Key key() {
//         return Keys.hmacShaKeyFor(
//             Decoders.BASE64.decode(jwtSecret)  // Corrected method, no change
//         );
//     }

//     // Get Username from JWT Token
//     public String getUsername(String token) {
//         Claims claims = Jwts.parserBuilder()  // Correct method
//             .setSigningKey(key())  // Correct method to set key
//             .build()
//             .parseClaimsJws(token)
//             .getBody();

//         return claims.getSubject();  // Correct method for getting subject
//     }

//     // Validate JWT Token
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }
// }
