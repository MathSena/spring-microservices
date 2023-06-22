package com.mathsena.employeeservice.service.impl;

import com.mathsena.employeeservice.dto.APIResponseDto;
import com.mathsena.employeeservice.dto.DepartmentDto;
import com.mathsena.employeeservice.dto.EmployeeDto;
import com.mathsena.employeeservice.entity.Employee;
import com.mathsena.employeeservice.repository.EmployeeRepository;
import com.mathsena.employeeservice.service.APIClient;
import com.mathsena.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
   // private WebClient webClient;

    private APIClient apiClient;



    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

/*        ResponseEntity<DepartmentDto> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/api/departments/" +
                        employee.getDepartmentCode(), DepartmentDto.class);
            DepartmentDto departmentDto = responseEntity.getBody();
*/

/*    DepartmentDto departmentDto = webClient.get()
            .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
            .retrieve()
            .bodyToMono(DepartmentDto.class)
            .block();

 */
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());


        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
