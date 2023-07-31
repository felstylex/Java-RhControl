/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RhControl.service;

import com.example.RhControl.model.UserModel;
import com.example.RhControl.repository.UserRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe
 */
@Service
public class UserService implements UserDetailsService {
    
    private UserRepository userRepository;
    
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) {
        UserModel user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));
        
        Set<GrantedAuthority> authority = user.getRoles().stream()
            .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), authority);
    }
}
