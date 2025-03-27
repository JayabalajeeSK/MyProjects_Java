package com.jb.spring_oauth_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers("/", "/login**", "/error", "/oauth2/**").permitAll() // Public endpoints
                    .anyRequest().authenticated() // Protect all other endpoints
            )
            .oauth2Login(oauth2 -> 
                oauth2
                    .loginPage("/oauth2/authorization/google") // Default login page for Google
                    .defaultSuccessUrl("/home", true) // Redirect after successful login
            );

        return http.build();
    }
}
