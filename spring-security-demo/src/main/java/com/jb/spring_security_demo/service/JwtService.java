// package com.jb.spring_security_demo.service;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;
// import io.jsonwebtoken.security.SignatureAlgorithm;

// @Service
// public class JwtService {

//     @SuppressWarnings("deprecation")
//     public String generateToken(String username) {
//         Map<String, Object> clains = new HashMap<>();
//         return Jwts.builder()
//                     .setClaims(clains)
//                     .setSubject(username)
//                     .setIssuedAt(new Date(System.currentTimeMillis()))
//                     .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))
//                     .signWith(getKey(), io.jsonwebtoken.SignatureAlgorithm.HS256).compact();


//     }

//     private Key getKey() {
//         byte[] keyBytes=Decoders.BASE64.decode(secretKey);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

// }
