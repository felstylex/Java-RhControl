/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RhControl.controller;

import com.example.RhControl.dto.LoginDto;
import com.example.RhControl.dto.UserDto;
import com.example.RhControl.model.RoleModel;
import com.example.RhControl.model.UserModel;
import com.example.RhControl.repository.RoleRepository;
import com.example.RhControl.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Felipe
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
        
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()
        ));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<>("Email já registrado", HttpStatus.BAD_REQUEST);
        }
        
        UserModel user = new UserModel();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        
        RoleModel roles = roleRepository.findByName("ROLE_ADMIN").get();
        
        user.setRoles(Collections.singleton(roles));
        
        userRepository.save(user);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
