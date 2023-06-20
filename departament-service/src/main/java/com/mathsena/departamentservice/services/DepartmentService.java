package com.mathsena.departamentservice.services;

import com.mathsena.departamentservice.dto.DepartmentDto;
import com.mathsena.departamentservice.entity.Department;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
