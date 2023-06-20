package com.mathsena.departamentservice.services.impl;

import com.mathsena.departamentservice.dto.DepartmentDto;
import com.mathsena.departamentservice.entity.Department;
import com.mathsena.departamentservice.respository.DepartmentRepository;
import com.mathsena.departamentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert department dto to department jpa entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());

        Department savedDepartment = departmentRepository.save(department);

        // Return a dto

        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );


    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);

        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode());
    }
}
