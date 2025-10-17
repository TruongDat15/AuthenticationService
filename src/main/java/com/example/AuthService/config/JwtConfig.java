//package com.example.AuthService.config;
//
//
//import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
//import com.nimbusds.jose.jwk.source.ImmutableSecret;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//
//@Configuration
//public class JwtConfig {
//
//
//    private final String secretKey = "9XKcKfPzrh0r4q2fUuD2ktTVi3K2skP6o6Lmr6JZC1o=";
//
////    @Bean
////    public JwtEncoder jwtEncoder() {
////
////
////        // ImmutableSecret là cách hiện đại để cung cấp Khóa Bí mật
////        // dưới dạng JWKSource cho NimbusJwtEncoder.
////
////    }
//
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        SecretKey key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HS512");
//
//        return NimbusJwtDecoder.withSecretKey(key)
//                .macAlgorithm(MacAlgorithm.HS512)
//                .build();
//    }
//}
