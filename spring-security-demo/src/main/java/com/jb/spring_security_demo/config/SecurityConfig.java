package com.jb.spring_security_demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean //- spring creates default bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(customizer -> customizer.disable());// crsf -> csrf.disable()
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());//request authentication
        //http.formLogin(Customizer.withDefaults()); //login form //dont need form login when it is stateless
        http.httpBasic(Customizer.withDefaults()); //for security
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //statefull to stateless
        return http.build();
    }
}