/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RhControl.repository;

import com.example.RhControl.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Felipe
 */
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    
}

