/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.RhControl.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public record EmployeeRecordDto(String name, String office, String department, LocalDate admissionDate, LocalDate birthDate, String adress, String email, String phoneNumber, BigDecimal salary, String status, String workedHours) {

}
