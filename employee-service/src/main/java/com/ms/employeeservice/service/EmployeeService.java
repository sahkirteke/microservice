package com.ms.employeeservice.service;

import com.ms.employeeservice.model.DTO.APIResponseDTO;
import com.ms.employeeservice.model.DTO.DepartmentDTO;
import com.ms.employeeservice.model.Employee;
import com.ms.employeeservice.model.DTO.EmployeeDTO;
import com.ms.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

//    private RestTemplate restTemplate;
//    private WebClient webClient;




    public EmployeeService(EmployeeRepository employeeRepository,
                           APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient=apiClient;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee employeeSaved= employeeRepository.save(employee);
        EmployeeDTO employeeDTOSaved = new EmployeeDTO();
        BeanUtils.copyProperties(employeeSaved,employeeDTOSaved);
        return employeeDTOSaved;

    }

    public APIResponseDTO getEmployeeById(Long id) {
       Optional<Employee> employee = employeeRepository.findById(id);

//       ResponseEntity<DepartmentDTO> responseEntity =
//                 restTemplate.getForEntity("http://localhost:8080/api/departments/getDepartment/"
//                        + employee.get().getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();

//      DepartmentDTO departmentDTO=  webClient.get()
//                .uri("http://localhost:8080/api/departments/getDepartment/"
//                        + employee.get().getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        DepartmentDTO departmentDTO = apiClient.getDepartment(employee.get().getDepartmentCode());
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee.get(),employeeDTO);
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;

    }
}
