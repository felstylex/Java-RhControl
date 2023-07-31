/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RhControl.controller;

import com.example.RhControl.dto.EmployeeRecordDto;
import com.example.RhControl.model.EmployeeModel;
import com.example.RhControl.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @PostMapping("/employee")
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeRecordDto employeeRecordDto) {
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(employeeModel));
    }
    
    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee.get());
    }
    
    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value="id") Long id,
            @RequestBody EmployeeRecordDto employeeRecordDto) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        
        if(employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
       }
       
        var employeeModel = employee.get();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.save(employeeModel));
    }
    
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value="id") Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        
        if(employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        }
        
        employeeRepository.delete(employee.get());
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
