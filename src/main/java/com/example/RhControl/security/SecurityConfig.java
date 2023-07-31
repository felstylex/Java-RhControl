/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RhControl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Felipe
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    private UserDetailsService userService;
    
    public SecurityConfig(UserDetailsService  userService) {
        this.userService = userService;
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain secutiryFilterChain(HttpSecurity http) throws Exception {
       http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((authorize) ->
               authorize.requestMatchers(HttpMethod.GET, "/**").permitAll()
               .requestMatchers("/**").permitAll()
               .anyRequest().authenticated()
       );
       
       return http.build();
    }
}
