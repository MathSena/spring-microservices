package com.mathsena.employeeservice.service;

import com.mathsena.employeeservice.dto.APIResponseDto;
import com.mathsena.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
