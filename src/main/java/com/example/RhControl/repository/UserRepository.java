/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RhControl.repository;

import com.example.RhControl.model.UserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Felipe
 */
public interface UserRepository extends JpaRepository<UserModel, Long>{
    Optional<UserModel> findByEmail(String email);
    Boolean existsByEmail(String email);
}

