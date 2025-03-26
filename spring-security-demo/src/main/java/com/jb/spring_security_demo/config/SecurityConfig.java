package com.jb.spring_security_demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;

    }



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

    // @Bean
    // public UserDetailsService UserDetailsService()
    // {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //                            .username("tharun")
    //                            .password("tharun")
    //                            .roles("USER");
    //     UserDetails admin = User.withDefaultPasswordEncoder()
    //                            .username("admin")
    //                            .password("admin")
    //                            .roles("ADMIN");
        
    //     return new InMemoryUserDetailsManager(user, admin);

    // }
}