package com.mathsena.departamentservice.services.impl;

import com.mathsena.departamentservice.dto.DepartmentDto;
import com.mathsena.departamentservice.entity.Department;
import com.mathsena.departamentservice.mapper.DepartmentMapper;
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
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        // Return a dto

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);




    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDepartmentDto(department);

    }
}
