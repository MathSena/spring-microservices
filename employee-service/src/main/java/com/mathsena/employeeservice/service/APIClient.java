package com.mathsena.employeeservice.service;

import com.mathsena.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);



}
